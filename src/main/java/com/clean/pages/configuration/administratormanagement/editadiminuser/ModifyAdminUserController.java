package com.clean.pages.configuration.administratormanagement.editadiminuser;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.configuration.administratormanagement.editadiminuser.ModifyAdminUserElement.modifyAdminUserElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.hover;


public class ModifyAdminUserController {
    private WebDriver driver;

    public ModifyAdminUserController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the Permission tab")
    public ModifyAdminUserController clickOnPermissionTab(){
        click(driver,modifyAdminUserElement(driver).permissionTab);
        return this;
    }
    @Step("Hover mouse to Adminsitrator menu")
    public ModifyAdminUserController hoverOnAdministratorMenu(){
        hover(driver,modifyAdminUserElement(driver).administratorMenu);
        return this;
    }
    @Step("Click on the Assign Role To Admin option")
    public ModifyAdminUserController clickOnAssignRoleOpt(){
        click(driver,modifyAdminUserElement(driver).assignRoleToAdminOpt);
        return this;
    }


}
