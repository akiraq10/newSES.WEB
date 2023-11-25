package com.clean.pages.users.edituser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserElement {
    private EditUserElement(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public static EditUserElement editUserElement(WebDriver driver){
        return new EditUserElement(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTxt;
    @FindBy(id = "edit-user-submit")
    WebElement saveBtn;
//    @FindBy(xpath = "//div[@class='alert success']")
//    WebElement alertSuccess;
    @FindBy(css = "[class='alert success']")
    WebElement alertSuccess;
}
