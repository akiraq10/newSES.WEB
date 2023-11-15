package com.clean.pages.configuration.administratormanagement.assignrole;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRoleElement.assignRoleElement;
import static com.clean.ults.ElementController.*;

public class AssignRoleController {
    private WebDriver driver;

    public AssignRoleController(WebDriver driver) {
        this.driver = driver;
    }

    public AssignRoleController selectRole(String roleName) throws InterruptedException {
        selectElementInTable(driver,assignRoleElement(driver).roleListTable,roleName);
        return this;
    }

    public AssignRoleController clickOnOKBtn(){
        click(driver,assignRoleElement(driver).okBtn);
        return this;
    }
}
