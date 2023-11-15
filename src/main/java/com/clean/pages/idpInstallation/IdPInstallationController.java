package com.clean.pages.idpInstallation;


import org.openqa.selenium.WebDriver;

import java.awt.*;

import static com.clean.pages.idpInstallation.IdPInstallationElement.getElement;
import static com.clean.ults.ElementController.*;


public class IdPInstallationController {
    private WebDriver driver ;

    public IdPInstallationController(WebDriver driver) {
        this.driver=driver;

    }


    public IdPInstallationController fillKF(String pathKF) throws AWTException, InterruptedException {
        click(driver, getElement(driver).keyfilelnk);
        Thread.sleep(1000);
        browseFile(pathKF);
        return this;
    }


    public IdPInstallationController fillKFPWD(String kfPWD) {
        fill(driver, getElement(driver).keyfilePasswordTxt, kfPWD);
        return this;
    }


    public IdPInstallationController fillServerName(String serverName) {
        fill(driver, getElement(driver).sqlServerNameTxt, serverName);
        return this;
    }


    public IdPInstallationController fillDatabase(String databaseName) {
        fill(driver, getElement(driver).sqlDatabaseNameTxt, databaseName);
        return this;
    }


    public IdPInstallationController fillSQLUserName(String userName) {
        fill(driver, getElement(driver).sqlUserNameTxt, userName);
        return this;
    }


    public IdPInstallationController fillSQLPWD(String pwd) {
        fill(driver, getElement(driver).sqlPasswordTxt, pwd);
        return this;
    }


    public IdPInstallationController fillIdPServerUrl(String url) {
        fill(driver, getElement(driver).severUrlTxt, url);
        return this;
    }


    public IdPInstallationController fillSESWebUrl(String url) {
        fill(driver, getElement(driver).sesWebUrlTxt, url);
        return this;
    }


    public IdPInstallationController enableDebug() {
        click(driver, getElement(driver).enableLoggingBtn);
        return this;
    }


    public IdPInstallationController clickSaveBtn() {
        click(driver, getElement(driver).SaveBtn);
        return this;
    }

}
