package com.clean.pages.users.assigngroup;

import org.openqa.selenium.WebDriver;

public class AssignGroupPage {
    public AssignGroupController act() {
        return assignGroupController;
    }

    public AssignGroupVerifier verify() {
        return assignGroupVerifier;
    }

    AssignGroupController assignGroupController;
    AssignGroupVerifier assignGroupVerifier;

    private AssignGroupPage(AssignGroupController assignGroupController, AssignGroupVerifier assignGroupVerifier) {
        this.assignGroupController = assignGroupController;
        this.assignGroupVerifier = assignGroupVerifier;
    }
    public static AssignGroupPage assignGroupPage(WebDriver driver){
        return new AssignGroupPage(new AssignGroupController(driver),new AssignGroupVerifier(driver));
    }

}
