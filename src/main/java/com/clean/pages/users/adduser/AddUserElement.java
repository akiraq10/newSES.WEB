package com.clean.pages.users.adduser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserElement {
    private AddUserElement(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public static AddUserElement getAddUserElem(WebDriver driver) {
        return new AddUserElement(driver);
    }

    @FindBy(id = "User_Name")
    WebElement userIDTXT;
    @FindBy(id = "password-input")
    WebElement passwordTXT;
    @FindBy(id = "FirstName")
    WebElement firstNameTXT;
    @FindBy(id = "LastName")
    WebElement lastNameTXT;
    @FindBy(id = "Phone")
    WebElement phoneTXT;
    @FindBy(id = "Email")
    WebElement emailTXT;
    @FindBy(id = "IsAdminSetPassword")
    WebElement finalPWDCheckBox;
    @FindBy(id = "Description")
    WebElement descriptionTXT;
    @FindBy(name = "UserType")
    WebElement userTypeOpt;
    @FindBy(id = "uniform-UserType")
    WebElement userTypeListBox;
    @FindBy(id = "new-user-submit")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@class='alert success']")
    WebElement successAlert;




}
