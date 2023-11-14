package com.clean.pages.configuration.administratormanagement.assignrole;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRoleElement.assignRoleElement;
import static com.clean.ults.ElementController.verify;

public class AssignRoleVerifier {
    private WebDriver driver;

    public AssignRoleVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Assign role page displayed")
    public AssignRoleVerifier isSelectRolePageDisplay(){
        verify(driver,assignRoleElement(driver).selectRoleBreadcrumb);
        return this;
    }
    @Step("Verify the alert success displayed")
    public AssignRoleVerifier isAlertSuccessDisplay(){
        verify(driver,assignRoleElement(driver).successAlert);
        return this;
    }

}
