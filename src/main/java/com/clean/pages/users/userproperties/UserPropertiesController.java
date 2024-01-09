package com.clean.pages.users.userproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.userproperties.UserPropertiesElements.getElement;
import static com.clean.ults.ElementController.*;

public class UserPropertiesController {
    private final WebDriver driver;

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
    @Step("Enter the Description as : {description}")
    public UserPropertiesController fillDescription(String description) {
        fill(driver,getElement(driver).descriptionTxt,description);
        return this;
    }

    @Step("Click on the User -> Delete user  option")
    public UserPropertiesController clickOnDeleteUserOpt() {
        click(driver,getElement(driver).deleteUserOpt);
        return this;
    }
    @Step("Click on the Yes button on the confirmation dialog")
    public UserPropertiesController clickOnYesBtnOnConfirmation() {
        click(driver,getElement(driver).yesBtnOnConfirmationDialog);
        return this;
    }
    @Step("Click on the User-> Move to Folder option")
    public UserPropertiesController clickOnMoveToFolderOption() {
        click(driver,getElement(driver).moveToFolderOpt);
        return this;
    }
    @Step("Click on the User-> Assign Key to User option")
    public UserPropertiesController clickOnAssignKeyToUserOption() {
        click(driver,getElement(driver).assignKeyToUserOpt);
        return this;
    }

}
