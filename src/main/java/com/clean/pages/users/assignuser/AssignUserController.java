package com.clean.pages.users.assignuser;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assignuser.AssignUserElement.getAssignUserEle;
import static com.clean.ults.ElementController.*;

public class AssignUserController {
    WebDriver driver;

    public AssignUserController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Select the user: {username}")
    public AssignUserController selectUser(String username) throws InterruptedException {
        selectElementHasSpaceInTextInTable(driver,getAssignUserEle(driver).selectUserTable,username);
        return this;

    }
    @Step("Click on the Save button")
    public AssignUserController clickOnSaveBtn(){
        click(driver,getAssignUserEle(driver).saveBtn);
        return this;
    }
}
