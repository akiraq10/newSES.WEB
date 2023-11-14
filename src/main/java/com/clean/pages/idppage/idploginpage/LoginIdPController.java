package com.clean.pages.idppage.idploginpage;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.idppage.idploginpage.LoginIdPElement.loginIdPElement;
import static com.clean.ults.ElementController.click;

public class LoginIdPController {
    private WebDriver driver;
    public LoginIdPController(WebDriver driver){
        this.driver=driver;
    }

    public LoginIdPController clickOnSignInBtn(){
        click(driver,loginIdPElement(driver).signInBtn);
        return this;
    }
}
