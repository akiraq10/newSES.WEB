package com.clean.pages.users.assigngroup;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assigngroup.AssignGroupElements.getEle;
import static com.clean.ults.ElementController.verify;

public class AssignGroupVerifier {
    WebDriver driver;

    public AssignGroupVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Assign group page is displayed")
    public AssignGroupVerifier isCheckAssignGroupPageDisplay(){
        verify(driver,getEle(driver).assignGroupBreadcrumb);
        return this;
    }
    @Step("Verify the 'Operation succeeded.' is displayed")
    public AssignGroupVerifier isCheckSuccessAlertDisplay(){
        verify(driver,getEle(driver).successAlert);
        return this;
    }


}
