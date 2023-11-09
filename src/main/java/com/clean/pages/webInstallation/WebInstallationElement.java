package com.clean.pages.webInstallation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebInstallationElement {


    @FindBy(id = "Keyfile")
    WebElement keyfileTxt;
    @FindBy(id = "KeyfilePassword")
    WebElement keyfilePasswordTxt;
    @FindBy(id = "SqlServerName")
    WebElement sqlServerNameTxt;
    @FindBy(id = "SqlDatabaseName")
    WebElement sqlDatabaseNameTxt;
    @FindBy(id = "SqlUserName")
    WebElement sqlUserNameTxt;
    @FindBy(id = "SqlPassword")
    WebElement sqlPasswordTxt;
    @FindBy(xpath = "//span[@aria-labelledby='EnableLogging-form-label']")
    WebElement enableLoggingBtn;
    @FindBy(id = "config-button")
    WebElement configBtn;
    @FindBy(id = "ServerPublicUrl")
    WebElement serverPublicUrlTxt;

    private WebInstallationElement(WebDriver driver) {
//        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    public static WebInstallationElement getElement(WebDriver driver) {
        return new WebInstallationElement(driver);
 }


}
