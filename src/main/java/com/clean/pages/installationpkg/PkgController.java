package com.clean.pages.installationpkg;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.PkgElement.pkgElement;
import static com.clean.ults.ElementController.*;

public class PkgController {
    private WebDriver driver;

    public PkgController(WebDriver driver) {
        this.driver = driver;
    }

    public PkgController clickOnInstallationPage(){
        click(driver,pkgElement(driver).installationPkg);
        return this;
    }

    public  PkgController hoverOnPackageMenu(){
        hover(driver,pkgElement(driver).packageMenu);
        return this;
    }

    public PkgController clickOnAddPackage(){
        click(driver,pkgElement(driver).addPackageOpt);
        return this;
    }

}
