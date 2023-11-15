package com.clean.pages.installationpkg;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.installationpkg.PkgElement.pkgElement;
import static com.clean.ults.ElementController.verify;

public class PkgVerifier {
    private WebDriver driver;

    public PkgVerifier(WebDriver driver) {
        this.driver = driver;
    }

    public PkgVerifier isInstallationPageDisplay(){
        verify(driver,pkgElement(driver).installationBreadcrumb);
        return this;
    }
}
