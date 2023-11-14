package com.clean.pages.configuration;

import org.openqa.selenium.WebDriver;

public class ConfigurationVerifier {
    private WebDriver driver;

    public ConfigurationVerifier(WebDriver driver) {
        this.driver = driver;
    }
    public ConfigurationVerifier isConfigurationPageDisplay(){

        return this;
    }
}
