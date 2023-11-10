package com.clean.pages.installationpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PkgElement {
    @FindBy(linkText = "Installation packages")
    WebElement installationPkg;
    @FindBy(id = "breadcrumb_Package_ViewPackages_2")
    WebElement installationBreadcrumb;
    @FindBy(id = "Actions_Type_Package_Basic")
    WebElement packageMenu;
    @FindBy(id = "Actions_Package_AddPackages")
    WebElement addPackageOpt;
    @FindBy(id = "Actions_Package_DeletePackageConfirmed")
    WebElement deletePackageOpt;
    @FindBy(id = "Actions_Package_ModifyPackages")
    WebElement modifyPackageOpt;
    @FindBy(id = "Actions_Package_CopyPackages")
    WebElement copyPackageOpt;
    private PkgElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public static PkgElement pkgElement(WebDriver driver) {
        return new PkgElement(driver);
    }


}
