package com.clean.pages.users.edituser;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.edituser.EditUserElement.editUserElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;

public class EditUserController {
    private WebDriver driver;

    public EditUserController(WebDriver driver) {
        this.driver = driver;
    }

    public  EditUserController fillEmail(String email){
        fill(driver,editUserElement(driver).emailTxt,email);
        return this;
    }

    public EditUserController clickOnSaveBtn(){
        click(driver,editUserElement(driver).saveBtn);
        return this;
    }
}
