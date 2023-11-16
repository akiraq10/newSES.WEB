package com.clean.pages.users.edituser;

import org.openqa.selenium.WebDriver;

public class EditUserPage {
    private EditUserPage(EditUserController editUserController, EditUserVerifier editUserVerifier) {
        this.editUserController = editUserController;
        this.editUserVerifier = editUserVerifier;
    }
    public  static EditUserPage editUserPage(WebDriver driver){
        return new EditUserPage(new EditUserController(driver),new EditUserVerifier(driver));
    }

    public EditUserController act() {
        return editUserController;
    }

    public EditUserVerifier verify() {
        return editUserVerifier;
    }

    EditUserController editUserController;
    EditUserVerifier editUserVerifier;

}
