package com.clean.pages.users.grouppropertiespermission;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.grouppropertiespermission.PermissionElements.getElem;
import static com.clean.ults.ElementController.verify;

public class PermissionVerifier {
    WebDriver driver;

    PermissionVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify The Alert Success is displayed")
    public PermissionVerifier isCheckAlertSuccessDisplay() {
        verify(driver,getElem(driver).alertSuccess);
        return this;
    }
}
