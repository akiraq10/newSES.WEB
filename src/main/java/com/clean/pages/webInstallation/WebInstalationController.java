package com.clean.pages.webInstallation;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.webInstallation.WebInstallationElement.getElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;

public class WebInstalationController {

    private WebDriver driver;

    public WebInstalationController(WebDriver driver) {
        this.driver = driver;

    }


    public WebInstalationController fillKF(String pathKF) {
        fill(driver, getElement(driver).keyfileTxt, pathKF);
        return this;
    }


    public WebInstalationController fillKFPwd(String kfPWD) {
        fill(driver, getElement(driver).keyfilePasswordTxt, kfPWD);
        return this;
    }


    public WebInstalationController fillServerName(String serverName) {
        fill(driver, getElement(driver).sqlServerNameTxt, serverName);
        return this;
    }


    public WebInstalationController fillDatabase(String databaseName) {
        fill(driver, getElement(driver).sqlDatabaseNameTxt, databaseName);
        return this;
    }


    public WebInstalationController fillSqlUserName(String sqlUser) {
        fill(driver, getElement(driver).sqlUserNameTxt, sqlUser);
        return this;
    }


    public WebInstalationController fillSQLPWD(String PWD) {
        fill(driver, getElement(driver).sqlPasswordTxt, PWD);
        return this;
    }


    public WebInstalationController enableDebugLog() {
        click(driver, getElement(driver).enableLoggingBtn);
        return this;
    }


    public WebInstalationController clickOnConfigureBtn() {
        click(driver, getElement(driver).configBtn);
        return this;
    }


    public WebInstalationController fillServerPublickUrL(String URL) {
        fill(driver, getElement(driver).serverPublicUrlTxt, URL);
        return this;
    }


}
