package com.clean.pages.login;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    LoginController loginController;
    LoginVerifier loginVerifier;
    private LoginPage(LoginController loginController,LoginVerifier loginVerifier){
        this.loginController= loginController;
        this.loginVerifier=loginVerifier;

    }
    public static LoginPage loginPage(WebDriver driver){
        return new LoginPage(new LoginController(driver),new LoginVerifier(driver));
    }
    public LoginController act(){
        return loginController;
    }
    public LoginVerifier verify(){
        return loginVerifier;
    }

}
