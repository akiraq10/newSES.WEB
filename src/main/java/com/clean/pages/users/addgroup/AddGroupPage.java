package com.clean.pages.users.addgroup;

import org.openqa.selenium.WebDriver;

public class AddGroupPage {
    AddGroupController addGroupController;
    AddGroupVerifier addGroupVerifier;
    private AddGroupPage(AddGroupController addGroupController, AddGroupVerifier addGroupVerifier) {
        this.addGroupController = addGroupController;
        this.addGroupVerifier = addGroupVerifier;

    }

    public static AddGroupPage addGroupPage(WebDriver driver) {
        return new AddGroupPage(new AddGroupController(driver), new AddGroupVerifier(driver));
    }

    public AddGroupController act() {
        return addGroupController;
    }

    public AddGroupVerifier verify() {
        return addGroupVerifier;
    }
}
