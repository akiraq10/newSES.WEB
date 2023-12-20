package com.clean.pages.users.assignserviceprovider;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.assignserviceprovider.AssignSPElements.getElem;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.selectElementInTable;

public class AssignSPController {
    WebDriver driver;

    AssignSPController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Select the Service Provider: {SPName}")
    public AssignSPController selectTheSPName(String SPName) throws InterruptedException {
        selectElementInTable(driver,getElem(driver).selectSPTable,SPName);
        return this;
    }
    @Step("Click on Save button")
    public AssignSPController clickOnSaveBtn() {
        click(driver,getElem(driver).saveBtn);
        return this;
    }
}
