import com.clean.platform.OSName;
import com.clean.platform.TestFunctionType;
import com.clean.platform.WebCapabilityTypeEx;
import com.google.common.reflect.ClassPath;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.net.URI;
import java.util.*;

import static com.clean.driver.DriverBase.readConfigFile;

public class Main implements WebCapabilityTypeEx {

    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) throws IOException {
        // get all test classes
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String osPlatformTest =System.getenv("OSPlatform");
        String testFunctionType=System.getenv("testFunctionType");
        String uri=System.getenv("uri");
        List<String> browsersRunTest= browserTestList(osPlatformTest);

        XmlSuite suite =generateXMLFile(listenerClasses(loader), testFunctionType,listTestCase(browsersRunTest,testClasses(loader)),uri);
        System.out.println(suite.toXml());
        TestNG testNG = new TestNG();


//        Add testSuite into suite list
//        List<XmlSuite> suites = new ArrayList<>();
//        suites.add(suite);
////
////        //Invoke run method
//        testNG.setXmlSuites(suites);
//        testNG.run();
    }

    //get test classes
    private static List<Class<?>> testClasses(ClassLoader loader) throws IOException {
        List<Class<?>> testClasses = new ArrayList<>();
        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoNAme = info.getName();
            boolean startWithTestDot = classInfoNAme.startsWith("testclass"); // lay tat cả class trong 'test' package
            boolean isServerTestClass= classInfoNAme.startsWith("testclass.server");
            boolean isTestNGClass= classInfoNAme.startsWith("testclass.testNG");
            boolean isIdPLoginTestClass= classInfoNAme.startsWith("testclass.client.idp");
            boolean isMainClass = classInfoNAme.startsWith("Main"); // check co phai Main.class ko
            //add class ko fai là Basetest.class and Main.class to testClass
            if (startWithTestDot && !isMainClass && !isServerTestClass && !isTestNGClass && !isIdPLoginTestClass) {
                testClasses.add(info.load());

            }

        }
        return testClasses;

    }

    //get listener classes
    private static List<Class<?>> listenerClasses(ClassLoader loader) throws IOException {
        List<Class<?>> listenerClasses=new ArrayList<>();
        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoNAme = info.getName();
            boolean isListenerClass = classInfoNAme.startsWith("com.clean.listener");
            boolean isRetryFailCase = classInfoNAme.startsWith("com.clean.listener.RetryFailCase");
            if (isListenerClass && !isRetryFailCase){
                listenerClasses.add(info.load());
            }
        }
        return listenerClasses;
    }

    private static List<String> browserTestList(String osPlatformTest){
        if (osPlatformTest == null) {
            throw new IllegalArgumentException("[ERR] please provider platform via -DosPlatform=");
        }

        try {
            OSName.valueOf(osPlatformTest);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERR] we don't support platform " + osPlatformTest + " , supported OS platforms: " + Arrays.toString(OSName.values()));
        }

        // Browser under test
        List<String> windowsBrowserList= Arrays.asList(readConfigFile.chrome(),readConfigFile.firefox());
        List<String> macBrowserList=Arrays.asList("safary");
        List<String> browserTestList= osPlatformTest.equalsIgnoreCase("windows")? windowsBrowserList: macBrowserList;
        return browserTestList;
    }

    // Assign test classes into browser
    private static Map<String,List<Class<?>>> listTestCase(List<String> browserList,List<Class<?>> testClasses){
        Map<String, List<Class<?>>> desiredCaps = new HashMap<>();
        for (int browser = 0; browser < browserList.size(); browser++) {
            desiredCaps.put(browserList.get(browser),testClasses);

        }

        return desiredCaps;

    }




    private static XmlSuite generateXMLFile(List<Class<?>> listenerClasses,String testFunctionType,Map<String,List<Class<?>>> testClasses,String uri ){
        XmlSuite suite=new XmlSuite();
        if(testFunctionType==null){
            throw new IllegalArgumentException("[ERR] please provider test Function type -DtestFunctionType= ");
        } else if (uri==null) {
            throw new IllegalArgumentException("[ERR] please provider test URL -Duri= ");
        }
        try {
            TestFunctionType.valueOf(testFunctionType);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERR] we don't support test function " + testFunctionType +
                    " , supported test function types : " + TestFunctionType.regression
                    +", " +TestFunctionType.basic);
        }

        suite.setName(testFunctionType.toUpperCase() + " TEST");
        for (Class<?> listenerClass : listenerClasses) {
            suite.addListener(listenerClass.getName());
        }

        List<XmlTest> allTests = new ArrayList<>();
        for (String browserName : testClasses.keySet()) {
            XmlTest test = new XmlTest(suite);
            test.setName(browserName);
            List<XmlClass> xmlClasses = new ArrayList<>();
            List<Class<?>> dedicatedClasses = testClasses.get(browserName);
            for (Class<?> dedicatedClass : dedicatedClasses) {
                xmlClasses.add(new XmlClass(dedicatedClass.getName()));

            }


            test.setXmlClasses(xmlClasses);
            test.addParameter(BROWSER, browserName);
            test.addParameter(URL, uri);


            if (testFunctionType.equalsIgnoreCase("regression")){
                test.addIncludedGroup(String.valueOf(TestFunctionType.regression));
            }else test.addIncludedGroup(String.valueOf(TestFunctionType.basic));


            test.setParallel(XmlSuite.ParallelMode.METHODS);
            allTests.add(test);

        }
        suite.setTests(allTests);
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setThreadCount(4);
        suite.setDataProviderThreadCount(4);

        return suite;

    }



}
