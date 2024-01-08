package com.clean.pages.users.userproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.userproperties.UserPropertiesElements.getElement;
import static com.clean.ults.ElementController.*;

public class UserPropertiesController {
    private WebDriver driver;

    public UserPropertiesController(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Hover to the User Menu")
    public UserPropertiesController hoverToUserMenu() {
        hover(driver,getElement(driver).userMenu);
        return this;
    }
    @Step("Click On The Add User To Group Option")
    public UserPropertiesController clickOnAddUserToGroupOpt() {
        click(driver,getElement(driver).addUserToGroupOpt);
        return this;
    }
    @Step("Enter the password as: {password}")
    public UserPropertiesController fillPassword(String password) {
        fill(driver,getElement(driver).passwordTxt,password);
        return this;
    }
    @Step("Click on the Save button")
    public UserPropertiesController clickOnSaveBtn() {
        click(driver,getElement(driver).saveBtn);
        return this;
    }
}
