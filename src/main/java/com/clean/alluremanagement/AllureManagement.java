package com.clean.alluremanagement;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.BeforeSuite;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureManagement {

    @BeforeSuite(alwaysRun = true)
    public void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "87.0.4280.88")
                        .put("URL", "http://programsbuzz.com").build(),
                System.getProperty("user.dir") + "/target/allure-results/");
    }


}
