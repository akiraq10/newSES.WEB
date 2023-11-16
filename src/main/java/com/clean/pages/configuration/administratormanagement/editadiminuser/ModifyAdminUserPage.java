package com.clean.pages.configuration.administratormanagement.editadiminuser;

import org.openqa.selenium.WebDriver;

public class ModifyAdminUserPage {
    ModifyAdminUserController modifyAdminUserController;
    ModifyAdminUserVerifier modifyAdminUserVerifier;
    private ModifyAdminUserPage(ModifyAdminUserController modifyAdminUserController, ModifyAdminUserVerifier modifyAdminUserVerifier) {
        this.modifyAdminUserController = modifyAdminUserController;
        this.modifyAdminUserVerifier = modifyAdminUserVerifier;
    }
    public static ModifyAdminUserPage modifyAdminUserPage(WebDriver driver){
        return new ModifyAdminUserPage(new ModifyAdminUserController(driver),new ModifyAdminUserVerifier(driver));
    }

    public ModifyAdminUserController act() {
        return modifyAdminUserController;
    }

    public ModifyAdminUserVerifier verify() {
        return modifyAdminUserVerifier;
    }


}
