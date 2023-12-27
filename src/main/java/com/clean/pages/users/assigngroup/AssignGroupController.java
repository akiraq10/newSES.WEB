package com.clean.pages.users.assigngroup;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assigngroup.AssignGroupElements.getEle;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.selectElementInTable;

public class AssignGroupController {
    WebDriver driver;

    public AssignGroupController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Select the Group: {groupName}")
    public AssignGroupController selectTheGroupToAssign(String groupName) throws InterruptedException {
        selectElementInTable(driver,getEle(driver).selectUserTable,groupName);
        return this;
    }
    @Step("Click on the Save button")
    public AssignGroupController clickOnSaveBtn(){
        click(driver,getEle(driver).saveBtn);
        return this;
    }
}
