package com.clean.pages.configuration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.ConfigurationElement.configurationElement;
import static com.clean.ults.ElementController.click;

public class ConfigurationController {
    private WebDriver driver;

    public ConfigurationController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the Configuration page")
    public ConfigurationController clickOnConfiguration(){
        click(driver,configurationElement(driver).configurationPage);
        return this;
    }
    @Step("Click on the Administrator Management page")
    public ConfigurationController clickOnAdministrator(){
        click(driver,configurationElement(driver).administratorPage);
        return this;
    }

}
