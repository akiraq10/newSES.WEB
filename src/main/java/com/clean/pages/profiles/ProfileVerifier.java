package com.clean.pages.profiles;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.profiles.ProfileElement.element;
import static com.clean.ults.ElementController.verify;

public class ProfileVerifier {
    private WebDriver driver;

    public ProfileVerifier(WebDriver driver) {
        this.driver = driver;
    }

    public ProfileVerifier isAddProfilePageDisplay(){
        verify(driver,element(driver).addProfileBreadCrumb);
        return this;
    }
}
