package com.clean.pages.adduser;

import org.openqa.selenium.WebDriver;

import static com.clean.pages.adduser.AddUserElement.getAddUserElem;
import static com.clean.ults.ElementController.verify;

public class AddUserVerifier {
    private WebDriver driver ;

    public AddUserVerifier(WebDriver driver) {
        this.driver=driver;

    }
    public AddUserVerifier verifyCreateUserSuccess(String expected){
        verify(driver, getAddUserElem(driver).successAlert, expected);
        return this;
    }
}
