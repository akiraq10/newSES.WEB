package com.clean.pages.users.assignuser;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assignuser.AssignUserElement.getAssignUserEle;
import static com.clean.ults.ElementController.verify;

public class AssignUserVerifier {
    WebDriver driver;

    public AssignUserVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Assign User page is displayed")
    public AssignUserVerifier isCheckAssignUserPageDisplay(){
        verify(driver,getAssignUserEle(driver).assignUserBreadcrumb);
        return this;
    }
}
