package com.clean.pages.users.edituser;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.edituser.EditUserElement.editUserElement;
import static com.clean.ults.ElementController.verify;

public class EditUserVerifier {
    private WebDriver driver;

    public EditUserVerifier(WebDriver driver) {
        this.driver = driver;
    }
    public EditUserVerifier isAlertSuccessDisplay(){
        verify(driver,editUserElement(driver).alertSuccess);
        return this;
    }
}
