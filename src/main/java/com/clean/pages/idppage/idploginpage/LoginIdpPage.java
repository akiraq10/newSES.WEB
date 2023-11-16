package com.clean.pages.idppage.idploginpage;

import org.openqa.selenium.WebDriver;

public class LoginIdpPage {

    LoginIdPVerifer loginIdPVerifer;
    LoginIdPController loginIdPController;
    private LoginIdpPage(LoginIdPVerifer loginIdPVerifer, LoginIdPController loginIdPController) {
        this.loginIdPVerifer = loginIdPVerifer;
        this.loginIdPController = loginIdPController;
    }
    public static LoginIdpPage loginIdpPage(WebDriver driver)
    {
        return new LoginIdpPage(new LoginIdPVerifer(driver), new LoginIdPController(driver));

    }

    public LoginIdPVerifer verify() {
        return loginIdPVerifer;
    }

    public LoginIdPController act() {
        return loginIdPController;
    }


}
