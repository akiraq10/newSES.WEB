package com.clean.pages.webInstallation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.webInstallation.WebInstallationElement.getElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;

public class WebInstalationController {

    private WebDriver driver;

    public WebInstalationController(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Inpurt the KF as: {pathKF}")
    public WebInstalationController fillKF(String pathKF) {
        fill(driver, getElement(driver).keyfileTxt, pathKF);
        return this;
    }

    @Step("Inpurt the KF PWD as: {kfPWD}")
    public WebInstalationController fillKFPwd(String kfPWD) {
        fill(driver, getElement(driver).keyfilePasswordTxt, kfPWD);
        return this;
    }

    @Step("Inpurt the Server Name as: {serverName}")
    public WebInstalationController fillServerName(String serverName) {
        fill(driver, getElement(driver).sqlServerNameTxt, serverName);
        return this;
    }

    @Step("Inpurt the SES Database as: {databaseName}")
    public WebInstalationController fillDatabase(String databaseName) {
        fill(driver, getElement(driver).sqlDatabaseNameTxt, databaseName);
        return this;
    }

    @Step("Inpurt the SQL user name as: {sqlUser}")
    public WebInstalationController fillSqlUserName(String sqlUser) {
        fill(driver, getElement(driver).sqlUserNameTxt, sqlUser);
        return this;
    }

    @Step("Inpurt the SQL password  as: {PWD}")
    public WebInstalationController fillSQLPWD(String PWD) {
        fill(driver, getElement(driver).sqlPasswordTxt, PWD);
        return this;
    }

    @Step("Enable the debbug log}")
    public WebInstalationController enableDebugLog() {
        click(driver, getElement(driver).enableLoggingBtn);
        return this;
    }

    @Step("Click on the Configure button")
    public WebInstalationController clickOnConfigureBtn() {
        click(driver, getElement(driver).configBtn);
        return this;
    }

    @Step("Inpurt the Server Public Url as: {URL}")
    public WebInstalationController fillServerPublickUrL(String URL) {
        fill(driver, getElement(driver).serverPublicUrlTxt, URL);
        return this;
    }


}
