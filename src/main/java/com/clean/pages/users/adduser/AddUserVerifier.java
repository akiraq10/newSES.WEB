package com.clean.pages.users.adduser;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.ults.ElementController.verify;

public class AddUserVerifier {
    private WebDriver driver ;

    public AddUserVerifier(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Verify the new user is created success and the alert {expected} is displayed")
    public AddUserVerifier verifyCreateUserSuccess(String expected){
        verify(driver, AddUserElement.getAddUserElem(driver).successAlert, expected);
        return this;
    }
}
