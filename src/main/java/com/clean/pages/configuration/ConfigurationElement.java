package com.clean.pages.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationElement {
    private ConfigurationElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static ConfigurationElement configurationElement(WebDriver driver){
        return new ConfigurationElement(driver);
    }

    @FindBy(linkText = "Configuration")
    WebElement configurationPage;
    @FindBy(linkText = "Service Settings")
    WebElement serviceSettingPage;
    @FindBy(linkText = "Administrator Management")
    WebElement administratorPage;
    @FindBy(linkText = "Folder Encryption Policies")
    WebElement folderEncryptPoliciesPage;
    @FindBy(linkText = "Server's RSA Keys")
    WebElement serverRSAKeysPage;
    @FindBy(linkText = "Licenses")
    WebElement licensesPage;
    @FindBy(linkText = "Options")
    WebElement optionsPage;
}
