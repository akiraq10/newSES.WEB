package com.clean.pages.users.assignuser;

import org.openqa.selenium.WebDriver;

public class AssignUserPage {
    AssignUserController assignUserController;
    AssignUserVerifier assignUserVerifier;

    private AssignUserPage(AssignUserController assignUserController, AssignUserVerifier assignUserVerifier) {
        this.assignUserController = assignUserController;
        this.assignUserVerifier = assignUserVerifier;
    }
    public static AssignUserPage assignUserPage(WebDriver driver){
        return new AssignUserPage(new AssignUserController(driver),new AssignUserVerifier(driver));
    }

    public AssignUserController act() {
        return assignUserController;
    }

    public AssignUserVerifier verify() {
        return assignUserVerifier;
    }
}
