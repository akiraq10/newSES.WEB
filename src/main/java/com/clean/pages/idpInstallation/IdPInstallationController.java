package com.clean.pages.idpInstallation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static com.clean.pages.idpInstallation.IdPInstallationElement.getElement;
import static com.clean.ults.ElementController.*;


public class IdPInstallationController {
    private WebDriver driver ;

    public IdPInstallationController(WebDriver driver) {
        this.driver=driver;

    }

    @Step("Input the KF path as: {pathKF}")
    public IdPInstallationController fillKF(String pathKF) throws AWTException, InterruptedException {
        click(driver, getElement(driver).keyfilelnk);
        Thread.sleep(1000);
        browseFile(pathKF);
        return this;
    }

    @Step("Input the KF password as: {kfPWD}")
    public IdPInstallationController fillKFPWD(String kfPWD) {
        fill(driver, getElement(driver).keyfilePasswordTxt, kfPWD);
        return this;
    }

    @Step("Input the Server Name as: {serverName}")
    public IdPInstallationController fillServerName(String serverName) {
        fill(driver, getElement(driver).sqlServerNameTxt, serverName);
        return this;
    }

    @Step("Input the SES database name path as: {databaseName}")
    public IdPInstallationController fillDatabase(String databaseName) {
        fill(driver, getElement(driver).sqlDatabaseNameTxt, databaseName);
        return this;
    }

    @Step("Input the SQL user name  as: {userName}")
    public IdPInstallationController fillSQLUserName(String userName) {
        fill(driver, getElement(driver).sqlUserNameTxt, userName);
        return this;
    }

    @Step("Input the SQL pwd  as: {pwd}")
    public IdPInstallationController fillSQLPWD(String pwd) {
        fill(driver, getElement(driver).sqlPasswordTxt, pwd);
        return this;
    }

    @Step("Input the IdP server Url as: {url}")
    public IdPInstallationController fillIdPServerUrl(String url) {
        fill(driver, getElement(driver).severUrlTxt, url);
        return this;
    }

    @Step("Input the SES.WEB usrl as: {url}")
    public IdPInstallationController fillSESWebUrl(String url) {
        fill(driver, getElement(driver).sesWebUrlTxt, url);
        return this;
    }

    @Step("Enable debug log")
    public IdPInstallationController enableDebug() {
        click(driver, getElement(driver).enableLoggingBtn);
        return this;
    }

    @Step("Click on the Save button")
    public IdPInstallationController clickSaveBtn() {
        click(driver, getElement(driver).SaveBtn);
        return this;
    }

}
