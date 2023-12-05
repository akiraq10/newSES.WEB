package com.clean.pages.users.assignKey;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assignKey.AssignKeyElement.getAssignElement;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.selectElementInTable;

public class AssignKeyController {
    WebDriver driver;

    public AssignKeyController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Select the key {keyName}")
    public AssignKeyController selectKey(String keyName) throws InterruptedException {
        selectElementInTable(driver,getAssignElement(driver).selectKeyTable,keyName);
        return this;
    }
    @Step("Click on the Save button")
    public AssignKeyController clickOnSaveBtn(){
        click(driver,getAssignElement(driver).saveBtn);
        return this;
    }


}
