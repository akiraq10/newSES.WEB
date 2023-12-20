package com.clean.pages.users.assignserviceprovider;

import org.openqa.selenium.WebDriver;

public class AssignSPPage {
    AssignSPController assignSPController;
    AssignSPVerifier assignSPVerifier;

    private AssignSPPage(AssignSPController assignSPController, AssignSPVerifier assignSPVerifier) {
        this.assignSPController = assignSPController;
        this.assignSPVerifier = assignSPVerifier;
    }
    public static AssignSPPage assignSPPage(WebDriver driver){
        return new AssignSPPage(new AssignSPController(driver),new AssignSPVerifier(driver));
    }

    public AssignSPController act() {
        return assignSPController;
    }

    public AssignSPVerifier verify() {
        return assignSPVerifier;
    }
}
