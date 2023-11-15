package com.clean.extendreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.sql.DriverManager;
import java.util.*;

import static com.clean.driver.DriverBase.driverThread;

public class ExtentReportManage {

    static ExtentReports extend;



    public static ExtentReports createInstance(){
        String fileName= getReportName();
        String directory=System.getProperty("user.dir")+ "/Report/";
        new File(directory).mkdirs();
        String path=directory+fileName;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Automation Reports");
        sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setTheme(Theme.DARK);



        extend =new ExtentReports();
        extend.setSystemInfo("Tester"," KKK");
        extend.setSystemInfo("Browser: ", WebDriverManager.chromedriver().getDownloadedDriverVersion());
        extend.setSystemInfo("OS ","WinServer 2k19");
        extend.attachReporter(sparkReporter);


        return extend;
    }

    public static String getReportName(){
        Date d= new Date();
        String fileName= "AutomationReport_"+ "_"
                + d.toString().replace(":","_").replace(" ","_")
                +".html";
        return fileName;
    }



}
