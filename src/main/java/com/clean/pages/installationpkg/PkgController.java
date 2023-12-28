package com.clean.pages.installationpkg;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.PkgElement.pkgElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.hover;

public class PkgController {
    private WebDriver driver;

    public PkgController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the Installation Package page")
    public PkgController clickOnInstallationPage(){
        click(driver,pkgElement(driver).installationPkg);
        return this;
    }
    @Step("Hover mouse to the Package Menu")
    public  PkgController hoverOnPackageMenu(){
        hover(driver,pkgElement(driver).packageMenu);
        return this;
    }
    @Step("Click on the Create Package from Profile option")
    public PkgController clickOnAddPackage(){
        click(driver,pkgElement(driver).addPackageOpt);
        return this;
    }

}
