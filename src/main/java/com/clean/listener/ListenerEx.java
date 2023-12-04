package com.clean.listener;

import com.clean.ults.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerEx implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){


        Log.error(result.getMethod().getDescription()+ " Failed");
        Log.info("Failed because of - "+ result.getThrowable());

    }
    @Override
    public void onStart(ITestContext context){

        Log.info("=========== onStart :-" + context.getName() + "-===============");

    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("=========== onFinish :-" + context.getName() + "-===============");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info(result.getMethod().getDescription() + " Skipped");
        Log.info("Skipped because of - "+ result.getThrowable());

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getMethod().getDescription() + " Passed");

    }


}
