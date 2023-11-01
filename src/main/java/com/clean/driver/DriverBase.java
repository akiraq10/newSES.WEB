package com.clean.driver;

import com.clean.ults.ReadConfigFile;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.*;

public class DriverBase {
    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList((new ArrayList<DriverFactory>()));
    private static  ThreadLocal<DriverFactory> driverThread;

    public static ReadConfigFile readConfigFile= ConfigFactory.create(ReadConfigFile.class);


   @BeforeSuite(alwaysRun = true)
    public static void initWebDriverObject(){
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactory webDriverThread =new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }


    public static WebDriver getDriver(){
        return driverThread.get().getDriver();
    }
    public static WebDriverWait getWaitDriver(){
        return driverThread.get().getWebDriverWait();
    }

  @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        for(DriverFactory driver : webDriverThreadPool){
            driver.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
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
            File screenShot =((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(fileLocaltion));

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


}
