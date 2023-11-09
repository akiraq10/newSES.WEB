package com.clean.pages.webInstallation;


import org.openqa.selenium.WebDriver;

public class WebInstallationPage {
    WebInstalationVerifier webInstalationVerifier;
    WebInstalationController webInstalationController;

    private WebInstallationPage(WebInstalationController webInstalationController, WebInstalationVerifier webInstalationVerifier) {
        this.webInstalationController = webInstalationController;
        this.webInstalationVerifier = webInstalationVerifier;
    }

    public static WebInstallationPage webInstallationPage(WebDriver driver) {
        return new WebInstallationPage(new WebInstalationController(driver), new WebInstalationVerifier(driver));
    }

    public WebInstalationController act() {
        return webInstalationController;
    }

    public WebInstalationVerifier verify() {
        return webInstalationVerifier;
    }
}
