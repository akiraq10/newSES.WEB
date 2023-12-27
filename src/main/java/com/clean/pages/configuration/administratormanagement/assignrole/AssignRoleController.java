package com.clean.pages.configuration.administratormanagement.assignrole;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRoleElement.assignRoleElement;
import static com.clean.ults.ElementController.*;

public class AssignRoleController {
    private WebDriver driver;

    public AssignRoleController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Select the role : {roleName}")
    public AssignRoleController selectRole(String roleName) throws InterruptedException {
        selectElementHasLinkInTable(driver,assignRoleElement(driver).roleListTable,roleName);
        return this;
    }
    @Step("Click on OK button")
    public AssignRoleController clickOnOKBtn(){
        click(driver,assignRoleElement(driver).okBtn);
        return this;
    }
}
