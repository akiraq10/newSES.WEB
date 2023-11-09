package com.clean.pages.users.addfolder;

import org.openqa.selenium.WebDriver;

public class AddFolderPage {

    AddFolderController addFolderController;
    AddFolderVerifier addFolderVerifier;

    private AddFolderPage(AddFolderController addFolderController, AddFolderVerifier addFolderVerifier) {
        this.addFolderController = addFolderController;
        this.addFolderVerifier = addFolderVerifier;

    }

    public static AddFolderPage addFolderPage(WebDriver driver) {
        return new AddFolderPage(new AddFolderController(driver), new AddFolderVerifier(driver));
    }

    public AddFolderController act() {
        return addFolderController;
    }

    public AddFolderVerifier verify() {
        return addFolderVerifier;
    }

}
