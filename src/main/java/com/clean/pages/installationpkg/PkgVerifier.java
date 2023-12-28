package com.clean.pages.installationpkg;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.PkgElement.pkgElement;
import static com.clean.ults.ElementController.verify;

public class PkgVerifier {
    private WebDriver driver;

    public PkgVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Installation Package page is displayed")
    public PkgVerifier isInstallationPageDisplay(){
        verify(driver,pkgElement(driver).installationBreadcrumb);
        return this;
    }
}
