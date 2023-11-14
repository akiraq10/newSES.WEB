package com.clean.pages.users.edituser;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.edituser.EditUserElement.editUserElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;

public class EditUserController {
    private WebDriver driver;

    public EditUserController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Input the email as: {email}")
    public  EditUserController fillEmail(String email){
        fill(driver,editUserElement(driver).emailTxt,email);
        return this;
    }
    @Step("Click on the Save button")
    public EditUserController clickOnSaveBtn(){
        click(driver,editUserElement(driver).saveBtn);
        return this;
    }
}
