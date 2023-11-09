package com.clean.pages.idpInstallation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdPInstallationElement {
//    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Upload a file']")
    WebElement keyfilelnk;
    @FindBy(name = "keyFilePin")
    WebElement keyfilePasswordTxt;
    @FindBy(name = "sqlDataSource")
    WebElement sqlServerNameTxt;
    @FindBy(name = "sqlInitialCatalog")
    WebElement sqlDatabaseNameTxt;
    @FindBy(name = "sqlUserId")
    WebElement sqlUserNameTxt;
    @FindBy(name = "sqlPassword")
    WebElement sqlPasswordTxt;
    @FindBy(name = "severUrl")
    WebElement severUrlTxt;
    @FindBy(name = "sesWebUrl")
    WebElement sesWebUrlTxt;
    @FindBy(xpath = "//input[@name='loggingEnabled']//parent::label")
    WebElement enableLoggingBtn;
    @FindBy(xpath = "//button[text()='Save']")
    WebElement SaveBtn;
    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signInBtn;

    private IdPInstallationElement(WebDriver driver) {
//        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    public static IdPInstallationElement getElement(WebDriver driver) {
        return new IdPInstallationElement(driver);
 }


}
