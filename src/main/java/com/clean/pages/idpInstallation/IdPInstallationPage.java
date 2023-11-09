package com.clean.pages.idpInstallation;

import org.openqa.selenium.WebDriver;

public class IdPInstallationPage {

    IdPInstallationController idPInstallationController;
    IdPInstallationVerifier idPInstallationVerifier;

    private IdPInstallationPage(IdPInstallationController loginController, IdPInstallationVerifier loginVerifier) {
        this.idPInstallationController = loginController;
        this.idPInstallationVerifier = loginVerifier;

    }

    public static IdPInstallationPage idPInstallationPage(WebDriver driver) {
        return new IdPInstallationPage(new IdPInstallationController(driver), new IdPInstallationVerifier(driver));
    }

    public IdPInstallationController act() {
        return idPInstallationController;
    }

    public IdPInstallationVerifier verify() {
        return idPInstallationVerifier;
    }

}
