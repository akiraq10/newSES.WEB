package com.clean.pages.installationpkg.addnewpacakge;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.installationpkg.addnewpacakge.AddPkgElement.addPkgElement;
import static com.clean.ults.ElementController.verify;

public class AddPkgVerifier {
    private WebDriver driver;

    public AddPkgVerifier(WebDriver driver) {
        this.driver = driver;
    }

    public AddPkgVerifier isAddPackagePageDisplay(){
        verify(driver,addPkgElement(driver).addInstallationPackageBreadcrumb);
        return this;
    }

    public AddPkgVerifier isConfirmationDialogDisplay(){
        verify(driver,addPkgElement(driver).confirmationDialog);
        return this;
    }
}
