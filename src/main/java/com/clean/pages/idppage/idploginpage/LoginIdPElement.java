package com.clean.pages.idppage.idploginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginIdPElement {

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInBtn;
    private LoginIdPElement(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static LoginIdPElement loginIdPElement(WebDriver driver){
        return new LoginIdPElement(driver);
    }

}
