package com.clean.listener;

import com.google.common.collect.ImmutableMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class ListenerEx implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Catching the failure");

    }
    @Override
    public void onStart(ITestContext context){
            allureEnvironmentWriter(
                    ImmutableMap.<String, String>builder()
                            .put("Browser", "Chrome")
                            .put("Browser.Version", "87.0.4280.88")
                            .put("URL", "http://programsbuzz.com").build(),
                    System.getProperty("user.dir") + "/target/allure-results/");

    }

}
