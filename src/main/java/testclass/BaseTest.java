package testclass;

import com.clean.driver.Browser;
import com.clean.driver.DriverFactory;
import com.clean.ults.ReadConfigFile;
import io.qameta.allure.Allure;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {
    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList((new ArrayList<>()));
    private static  ThreadLocal<DriverFactory> driverThread;

    public static ReadConfigFile readConfigFile= ConfigFactory.create(ReadConfigFile.class);
    public String uri;
    public String browser;
    public String adminSESWEBUser=readConfigFile.username();
    public String pwdSESWEBUser=readConfigFile.password();

    public WebDriver getDriver() throws MalformedURLException {
        return driverThread.get().getDriver(Browser.valueOf(browser),uri);
    }

    @BeforeTest(alwaysRun = true)
    public void initWebDriverObject(){
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactory webDriverThread =new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @Parameters({"browser","uri"})
    @BeforeMethod
    public void initBrowser(String browser, String uri){
        this.browser=browser;
        this.uri=uri;
    }


  @AfterTest(alwaysRun = true)
    public void quitDriverSession() {
      try {
          if (driverThread!=null) {
              for (DriverFactory driverFactory : webDriverThreadPool) {
                  driverFactory.quitDriverSession();
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }

  }

   @AfterMethod(alwaysRun = true)
    public void takeScreenShoot(ITestResult result) throws MalformedURLException {
        getDriver().manage().deleteAllCookies();

        if(result.getStatus() == ITestResult.FAILURE){
            //1. get the test method name
            String testMethod = result.getName();

            //2. Declare File Location
            Calendar calendar =new GregorianCalendar();
            int y =calendar.get(Calendar.YEAR);
            int month =calendar.get(Calendar.MONTH);
            int day =calendar.get(Calendar.DATE);
            int hr =calendar.get(Calendar.HOUR_OF_DAY);
            int min =calendar.get(Calendar.MINUTE);
            int sec =calendar.get(Calendar.MILLISECOND);

            String takeTime =y + "-" + (month+1) + "-" + day + "-" + hr +"-" +min +"-"+sec;


            String folderTestDate="Failed Results IMGs Date " +month +"-" +day+"-"+y;
            String imageName=testMethod+"-"+takeTime+".png";
            String fileLocaltion = System.getProperty("user.dir") + "/screenshots/"+folderTestDate+"/"+imageName;


            //3. Save screenshot to the system
            File screenShot =((TakesScreenshot) driverThread.get().getChromrDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(fileLocaltion));
                Path content = Paths.get(fileLocaltion);
                try (InputStream is = Files.newInputStream(content)){
                    Allure.addAttachment(testMethod,is);
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


}
