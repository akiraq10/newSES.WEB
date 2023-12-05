package com.clean.pages.users.assignKey;

import org.openqa.selenium.WebDriver;

public class AssignKeyPage {
    public AssignKeyController act() {
        return assignKeyController;
    }

    public AssignKeyVerifier verify() {
        return assignKeyVerifier;
    }

    AssignKeyController assignKeyController;
    AssignKeyVerifier assignKeyVerifier;

    private AssignKeyPage(AssignKeyController assignKeyController, AssignKeyVerifier assignKeyVerifier) {
        this.assignKeyController = assignKeyController;
        this.assignKeyVerifier = assignKeyVerifier;
    }
    public static AssignKeyPage assignKeyPage(WebDriver driver){
        return new AssignKeyPage(new AssignKeyController(driver),new AssignKeyVerifier(driver));
    }
}
