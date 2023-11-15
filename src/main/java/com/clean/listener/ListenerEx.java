package com.clean.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.clean.extendreport.ExtentReportManage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Arrays;


public class ListenerEx implements ITestListener {
    static ExtentReports extent= ExtentReportManage.createInstance();
    public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
    @Override
    public void onFinish(ITestContext Result) {

        if(extent!=null){
            extent.flush();
        }


    }

    @Override
    public void onStart(ITestContext Result) {
//        System.out.println("this is onStart" + Result.getName());


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
//        System.out.println("this is onTestFailedButWithinSuccessPercentage" +Result.getName());

    }
    @Override
    public void onTestFailure(ITestResult Result){
//        System.out.println("Catching the failure");
        String methodName=Result.getMethod().getMethodName();
        String exceptionMessage= Arrays.toString(Result.getThrowable().getStackTrace());
        extentTest.get().fail("<details><summary><b><font color=red>" +
                "Exception Occurred, click to see details:"+"</font></b></summary>"+
                exceptionMessage.replaceAll(",","<br>") + "</details> \n");

        String logText="<b>Test Method " +methodName+" Failed</b>";
        Markup m= MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL,m);


    }
    @Override
    public void onTestSkipped(ITestResult Result) {
//        System.out.println("The name of the testcase Skipped is :"+Result.getName());
        String logText="<b> Test Method "+ Result.getMethod().getMethodName()+" Skip<b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREY);
        extentTest.get().log(Status.SKIP,m);


    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result) {

       ExtentTest test=extent.createTest(Result.getTestClass().getName()
                + " :: "
                +Result.getMethod().getMethodName());
        extentTest.set(test);
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
//        System.out.println("The name of the testcase passed is :"+Result.getName());
        String logText="<b> Test Method "+ Result.getMethod().getMethodName()+" Successful<b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS,m);

    }





}
