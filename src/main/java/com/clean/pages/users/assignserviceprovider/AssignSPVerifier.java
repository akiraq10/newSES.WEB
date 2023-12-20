package com.clean.pages.users.assignserviceprovider;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assignserviceprovider.AssignSPElements.getElem;
import static com.clean.ults.ElementController.verify;

public class AssignSPVerifier {
    WebDriver driver;

    AssignSPVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Assign Page is displayed")
    public AssignSPVerifier isCheckAssignSPPageDisplay() {
        verify(driver,getElem(driver).assignSPBreadcrumb);
        return this;
    }
}
