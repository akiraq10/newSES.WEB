package com.clean.pages.login;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.login.LoginElement.getLoginElement;
import static com.clean.ults.ElementController.*;


public class LoginController   {
    private WebDriver driver ;
    public LoginController(WebDriver driver){
        this.driver=driver;

    }
    

    public LoginController fillUserName(String username) {
        fill(driver,getLoginElement(driver).userName,username);
        return this;
    }

    public LoginController fillPassword(String password) {
        fill(driver,getLoginElement(driver).password,password);
        return this;
    }

    public void clickONLoginBtn() {
        click(driver,getLoginElement(driver).loginBtn);
    }
}
