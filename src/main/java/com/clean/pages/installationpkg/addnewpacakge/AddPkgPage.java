package com.clean.pages.installationpkg.addnewpacakge;

import org.openqa.selenium.WebDriver;

public class AddPkgPage {
    AddPkgController addPkgController;
    AddPkgVerifier addPkgVerifier;

    private AddPkgPage(AddPkgController addPkgController, AddPkgVerifier addPkgVerifier) {
        this.addPkgController = addPkgController;
        this.addPkgVerifier = addPkgVerifier;
    }
    public static AddPkgPage addPkgPage(WebDriver driver){
        return new AddPkgPage(new AddPkgController(driver),new AddPkgVerifier(driver));
    }


    public AddPkgController act() {
        return addPkgController;
    }

    public AddPkgVerifier verify() {
        return addPkgVerifier;
    }
}
