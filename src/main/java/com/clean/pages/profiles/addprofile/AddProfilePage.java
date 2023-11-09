package com.clean.pages.profiles.addprofile;

import org.openqa.selenium.WebDriver;

public class AddProfilePage {
    AddProfileController addProfileController;
    AddProfileVerifier addProfileVerifier;

    private AddProfilePage(AddProfileController addProfileController, AddProfileVerifier addProfileVerifier) {
        this.addProfileController = addProfileController;
        this.addProfileVerifier = addProfileVerifier;
    }
    public static AddProfilePage addProfilePage(WebDriver driver){
        return new AddProfilePage(new AddProfileController(driver),new AddProfileVerifier(driver));
    }


    public AddProfileController act() {
        return addProfileController;
    }

    public AddProfileVerifier verify() {
        return addProfileVerifier;
    }
}
