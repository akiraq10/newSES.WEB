package com.clean.pages.configuration;

import org.openqa.selenium.WebDriver;

public class ConfigurationPage {
    private ConfigurationPage(ConfigurationController configurationController, ConfigurationVerifier configurationVerifier) {
        this.configurationController = configurationController;
        this.configurationVerifier = configurationVerifier;
    }
    public static ConfigurationPage configurationPage(WebDriver driver){
        return new ConfigurationPage(new ConfigurationController(driver),new ConfigurationVerifier(driver));
    }

    public ConfigurationController act() {
        return configurationController;
    }

    public ConfigurationVerifier verify() {
        return configurationVerifier;
    }

    ConfigurationController configurationController;
    ConfigurationVerifier configurationVerifier;
}
