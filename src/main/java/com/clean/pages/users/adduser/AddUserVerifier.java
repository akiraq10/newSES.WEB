package com.clean.pages.users.adduser;


import org.openqa.selenium.WebDriver;

import static com.clean.ults.ElementController.verify;

public class AddUserVerifier {
    private final WebDriver driver ;

    public AddUserVerifier(WebDriver driver) {
        this.driver=driver;

    }

    public AddUserVerifier verifyCreateUserSuccess(String expected){
        verify(driver, AddUserElement.getAddUserElem(driver).successAlert, expected);
        return this;
    }
}
