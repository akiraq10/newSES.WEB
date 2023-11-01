package com.clean.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class ListenerEx implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Catching the failure");

    }
}
