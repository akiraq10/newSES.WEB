package com.clean.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElement {
    private LoginElement(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

 public static LoginElement getLoginElement(WebDriver driver){
        return new LoginElement(driver);
 }

    @FindBy(id = "UserName")
    WebElement userName;
    @FindBy(css = "input[type='password']:nth-of-type(1)")
    WebElement password;
    @FindBy(id = "ses-submit-btn")
    WebElement loginBtn;
    @FindBy(id = "breadcrumb_Folder_ViewFolder_0")
    WebElement logoWMGBtn;
    @FindBy(className = "loginValidationErrors")
    WebElement unsuccessfulError;


}
