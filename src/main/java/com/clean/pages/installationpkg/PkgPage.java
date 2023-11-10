package com.clean.pages.installationpkg;

import org.openqa.selenium.WebDriver;

public class PkgPage {
    PkgController pkgController;
    PkgVerifier pkgVerifier;

    private PkgPage(PkgController pkgController, PkgVerifier pkgVerifier) {
        this.pkgController = pkgController;
        this.pkgVerifier = pkgVerifier;
    }
    public static PkgPage pkgPage(WebDriver driver)
    {
        return new PkgPage(new PkgController(driver),new PkgVerifier(driver));
    }

    public PkgController act() {
        return pkgController;
    }

    public PkgVerifier verify() {
        return pkgVerifier;
    }
}
