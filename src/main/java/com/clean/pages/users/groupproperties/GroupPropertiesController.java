package com.clean.pages.users.groupproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.groupproperties.GroupPropertiesElements.getEle;
import static com.clean.ults.ElementController.*;

public class GroupPropertiesController {
    WebDriver driver;

     GroupPropertiesController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse to the General Menu")
    public GroupPropertiesController hoverToGeneralMenu() {
         hover(driver,getEle(driver).generalMenu);
         return this;
    }
    @Step("Click on the Back option")
    public GroupPropertiesController clickOnBackOption() {
         click(driver,getEle(driver).backOpt);
         return this;
    }
    @Step("Enter the Group Name: {groupName}")
    public GroupPropertiesController enterGroupName(String groupName) {
         fill(driver,getEle(driver).groupNameTxt,groupName);
         return this;
    }
    @Step("Enter the Description: {description}")
    public GroupPropertiesController enterGroupDescription(String description) {
         fill(driver,getEle(driver).descriptionTxt,description);
         return this;
    }
    @Step("Click on the Save button")
    public GroupPropertiesController clickOnSaveBtn(){
         click(driver,getEle(driver).saveBtn);
         return this;
    }
    @Step("Click on the Permission Tab")
    public GroupPropertiesController clickOnPermissionTab() {
         click(driver,getEle(driver).permissionsTab);
         return this;
    }
}
