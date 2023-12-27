package com.clean.pages.users.userproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.userproperties.UserPropertiesElements.getElement;
import static com.clean.ults.ElementController.verify;

public class UserPropertiesVerifier {
    private WebDriver driver;

    public UserPropertiesVerifier(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify the User properties-> Properties: General page is displayed")
    public UserPropertiesVerifier isCheckUserPropertiesGeneralPageDisplay() {
        verify(driver,getElement(driver).userGeneralBreadcrumb);
        return this;
    }
}
