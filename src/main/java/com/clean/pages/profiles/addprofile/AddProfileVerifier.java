package com.clean.pages.profiles.addprofile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.profiles.addprofile.AddProfileElement.addProfileElement;
import static com.clean.ults.ElementController.verify;

public class AddProfileVerifier {
    private WebDriver driver;

    public AddProfileVerifier(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify the Confirmation dialog is displayed")
    public AddProfileVerifier isConfirmDialogDisplay(String expected){
        verify(driver,addProfileElement(driver).confirmDialog,expected);
        return this;
    }
}
