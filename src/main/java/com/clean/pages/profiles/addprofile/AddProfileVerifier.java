package com.clean.pages.profiles.addprofile;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.profiles.addprofile.AddProfileElement.addProfileElement;
import static com.clean.ults.ElementController.verify;

public class AddProfileVerifier {
    private WebDriver driver;

    public AddProfileVerifier(WebDriver driver) {
        this.driver = driver;
    }


    public AddProfileVerifier isConfirmDialogDisplay(){
        verify(driver,addProfileElement(driver).confirmDialog);
        return this;
    }
}
