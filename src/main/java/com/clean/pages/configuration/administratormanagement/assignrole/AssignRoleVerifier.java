package com.clean.pages.configuration.administratormanagement.assignrole;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRoleElement.assignRoleElement;
import static com.clean.ults.ElementController.verify;

public class AssignRoleVerifier {
    private WebDriver driver;

    public AssignRoleVerifier(WebDriver driver) {
        this.driver = driver;
    }

    public AssignRoleVerifier isSelectRolePageDisplay(){
        verify(driver,assignRoleElement(driver).selectRoleBreadcrumb);
        return this;
    }

    public AssignRoleVerifier isAlertSuccessDisplay(){
        verify(driver,assignRoleElement(driver).successAlert);
        return this;
    }

}
