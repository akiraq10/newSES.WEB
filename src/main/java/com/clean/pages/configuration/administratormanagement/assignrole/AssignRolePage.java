package com.clean.pages.configuration.administratormanagement.assignrole;

import org.openqa.selenium.WebDriver;

public class AssignRolePage {
    AssignRoleController assignRoleController;
    AssignRoleVerifier assignRoleVerifier;

    private AssignRolePage(AssignRoleController assignRoleController, AssignRoleVerifier assignRoleVerifier) {
        this.assignRoleController = assignRoleController;
        this.assignRoleVerifier = assignRoleVerifier;
    }
    public static AssignRolePage assignRolePage(WebDriver driver){
        return new AssignRolePage(new AssignRoleController(driver),new AssignRoleVerifier(driver));
    }

    public AssignRoleController act() {
        return assignRoleController;
    }

    public AssignRoleVerifier verify() {
        return assignRoleVerifier;
    }
}
