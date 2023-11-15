package com.clean.pages.configuration.administratormanagement.editadiminuser;


import org.openqa.selenium.WebDriver;
import static com.clean.pages.configuration.administratormanagement.editadiminuser.ModifyAdminUserElement.modifyAdminUserElement;
import static com.clean.ults.ElementController.*;


public class ModifyAdminUserController {
    private WebDriver driver;

    public ModifyAdminUserController(WebDriver driver) {
        this.driver = driver;
    }

    public ModifyAdminUserController clickOnPermissionTab(){
        click(driver,modifyAdminUserElement(driver).permissionTab);
        return this;
    }

    public ModifyAdminUserController hoverOnAdministratorMenu(){
        hover(driver,modifyAdminUserElement(driver).administratorMenu);
        return this;
    }

    public ModifyAdminUserController clickOnAssignRoleOpt(){
        click(driver,modifyAdminUserElement(driver).assignRoleToAdminOpt);
        return this;
    }


}
