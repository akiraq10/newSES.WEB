package com.clean.pages.users.assignKey;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assignKey.AssignKeyElement.getAssignElement;
import static com.clean.ults.ElementController.verify;

public class AssignKeyVerifier {
    WebDriver driver;

    public AssignKeyVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Assign Key page is displayed")
    public AssignKeyVerifier isCheckAssignKeyPageDisplay(){
        verify(driver,getAssignElement(driver).assignKeyBreadcrumb);
        return this;
    }
    @Step("Verify The new key is assigned to folder success")
    public AssignKeyVerifier isCheckAlertSuccessDisplay(){
        verify(driver,getAssignElement(driver).alertSuccess);
        return this;
    }


}
