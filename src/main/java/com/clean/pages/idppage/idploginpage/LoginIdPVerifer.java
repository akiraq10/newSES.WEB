package com.clean.pages.idppage.idploginpage;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.idppage.idploginpage.LoginIdPElement.loginIdPElement;
import static com.clean.ults.ElementController.verify;

public class LoginIdPVerifer {
    private WebDriver driver;
    public LoginIdPVerifer (WebDriver driver){
        this.driver=driver;
    }

    public LoginIdPVerifer isSignInBtnDisplay(){
        verify(driver,loginIdPElement(driver).signInBtn);
        return this;
    }

}
