package com.clean.pages.installationpkg.addnewpacakge;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.addnewpacakge.AddPkgElement.addPkgElement;
import static com.clean.ults.ElementController.verify;

public class AddPkgVerifier {
    private WebDriver driver;

    public AddPkgVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Add new Installation Package page is displayed ")
    public AddPkgVerifier isAddPackagePageDisplay(){
        verify(driver,addPkgElement(driver).addInstallationPackageBreadcrumb);
        return this;
    }
    @Step("Verify the Confirmation dialog  is displayed ")
    public AddPkgVerifier isConfirmationDialogDisplay(String expected){
        verify(driver,addPkgElement(driver).confirmationDialog,expected);
        return this;
    }
}
