package com.clean.pages.users.addfolder;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.ults.ElementController.verify;


public class AddFolderVerifier {
    private WebDriver driver;


    public AddFolderVerifier(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Expected: The alert Operation succeeded is displayed ")
    public AddFolderVerifier VerifyCreateFolderSuccess(String expected) {
        verify(driver, AddFolderElement.getAddFolderElement(driver).successAlert, expected);
        return this;

    }


}
