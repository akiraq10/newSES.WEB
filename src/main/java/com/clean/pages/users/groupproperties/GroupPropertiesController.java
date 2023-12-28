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
    @Step("Click on the Keys Tab")
    public GroupPropertiesController clickOnKeysTab() {
         click(driver,getEle(driver).keysTab);
         return this;
    }
    @Step("Hover mouse to Group Menu")
    public GroupPropertiesController hoverToGroupMenu() {
        hover(driver,getEle(driver).groupMenu);
        return this;
    }
    @Step("Click on Assign key option")
    public GroupPropertiesController clickOnAssignKeyOpt() {
        click(driver,getEle(driver).assignKeyOpt);
        return this;
    }
    @Step("Click on Remove key option")
    public GroupPropertiesController clickOnRemoveKeyOpt() {
        click(driver,getEle(driver).removeKeyOpt);
        return this;
    }
    @Step("Select the :{keyName} key in table")
    public GroupPropertiesController selectKeyNameInTable(String keyName) throws InterruptedException {
        selectElementInTable(driver,getEle(driver).selectTable,keyName);
        return this;
    }
    @Step("Click on the Groups Tab")
    public GroupPropertiesController clickOnGroupTab(){
         click(driver,getEle(driver).groupsTab);
         return this;
    }
    @Step("Click on the Assign Group option")
    public GroupPropertiesController clickOnAssignGroup() {
         click(driver,getEle(driver).assignGroupOpt);
         return this;
    }
    @Step("Click on the Remove Group option")
    public GroupPropertiesController clickOnRemoveGroup() {
        click(driver,getEle(driver).removeGroupOpt);
        return this;
    }
    @Step("Select the :{groupName} key in table")
    public GroupPropertiesController selectGroupNameInTable(String groupName) throws InterruptedException {
        selectElementInTable(driver,getEle(driver).selectTable,groupName);
        return this;
    }
    @Step("Select the :{SPName} key in table")
    public GroupPropertiesController selectSPInTable(String SPName) throws InterruptedException {
        selectElementInTable(driver,getEle(driver).selectTable,SPName);
        return this;
    }
    @Step("Click on Yes button on the Confirmation dialog")
    public GroupPropertiesController clickOnYesBtnOnConfirmationDialog() {
         click(driver,getEle(driver).yesOnConfirmationDialogBtn);
         return this;
    }
    @Step("Click on the Service Provider tab")
    public GroupPropertiesController clickOnSPTab() {
         click(driver,getEle(driver).serviceProviderTab);
         return this;
    }
    @Step("Click on the Assign Service Provider option")
    public GroupPropertiesController clickOnTheAssignSPOpt() {
         click(driver,getEle(driver).assignServiceProviderOpt);
         return this;
    }
    @Step("Click on the Remove Service Provider option")
    public GroupPropertiesController clickOnTheRemoveSPOpt() {
         click(driver,getEle(driver).removeServiceProviderOpt);
         return this;
    }
}
