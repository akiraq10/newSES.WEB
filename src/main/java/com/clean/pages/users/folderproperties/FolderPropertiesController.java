package com.clean.pages.users.folderproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.folderproperties.FolderPropertiesElements.getFolderElement;
import static com.clean.ults.ElementController.*;

public class FolderPropertiesController {
    private WebDriver driver;

    public FolderPropertiesController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse on General menu")
    public FolderPropertiesController hoverOnGeneralMenu(){
        hover(driver,getFolderElement(driver).generalMEnu);
        return this;
    }
    @Step("Hover mouse on Folder menu")
    public FolderPropertiesController hoverOnFolderMenu(){
        hover(driver,getFolderElement(driver).folderMenu);
        return this;
    }
    @Step("Click on Back option")
    public FolderPropertiesController clickOnBackOption(){
        click(driver,getFolderElement(driver).backOpt);
        return this;
    }
    @Step("Click on Add folder option")
    public FolderPropertiesController clickOnAddFolderOpt(){
        click(driver,getFolderElement(driver).addFolderOpt);
        return this;

    }
    @Step("Click on Add New user option")
    public FolderPropertiesController clickOnAddNewUserOpt(){
        click(driver,getFolderElement(driver).addNewUserOpt);
        return this;

    }
    @Step("Click on Add New Group option")
    public FolderPropertiesController clickOnAddNewGroupOpt(){
        click(driver,getFolderElement(driver).addNewGroupOpt);
        return this;

    }
    @Step("Input the folder name as: {folderName}")
    public FolderPropertiesController fillFolderName(String folderName){
        fill(driver,getFolderElement(driver).folderNameTxt,folderName);
        return this;
    }
    @Step("Input the Description as: {description}")
    public FolderPropertiesController fillDescription(String description){
        fill(driver,getFolderElement(driver).descriptionTxt,description);
        return this;
    }
    @Step("Click on the Save button")
    public FolderPropertiesController clickOnSaveBtn(){
        click(driver,getFolderElement(driver).saveBtn);
        return this;
    }
    @Step("Input the group name as: {groupName}")
    public FolderPropertiesController fillGroupName(String groupName){
        fill(driver,getFolderElement(driver).groupNameTxt,groupName);
        return this;
    }
    @Step("Input the User ID as :{userID}")
    public FolderPropertiesController fillUserID(String userID){
        fill(driver,getFolderElement(driver).userIDTxt,userID);
        return this;

    }
    @Step("Input the User ID as :{password}")
    public FolderPropertiesController fillPassword(String password){
        fill(driver,getFolderElement(driver).passwordTxT,password);
        return this;

    }
    @Step("Click on the Challenge Response option")
    public FolderPropertiesController clickOnChallengeResponseOpt(){
        click(driver,getFolderElement(driver).challengeResponseOpt);
        return this;

    }
    @Step("Click on Delete Folder opt")
    public FolderPropertiesController clickDeleteFolderOpt(){
        click(driver,getFolderElement(driver).deleteFolderOpt);
        return this;
    }
    @Step("Click on Yes button on confirmation dialog")
    public FolderPropertiesController clickOnYesBtnOnConfirmDialog() {
        click(driver,getFolderElement(driver).yesBtnOnConfirmDialog);
        return this;
    }
    @Step("Click on No button on confirmation dialog")
    public FolderPropertiesController clickOnNoBtnOnConfirmDialog() {
        click(driver,getFolderElement(driver).noBtnOnConfirmDialog);
        return this;
    }
    @Step("Click on View logs option ")
    public FolderPropertiesController clickOnViewLog() {
        click(driver,getFolderElement(driver).viewLogsOpt);
        return this;
    }
    @Step("Click on the Key tab")
    public FolderPropertiesController clickKeyTab(){
        click(driver,getFolderElement(driver).keysTab);
        return this;
    }
    @Step("Click on Assign key option")
    public FolderPropertiesController clickOnAssignKey(){
        click(driver,getFolderElement(driver).assignKeyOpt);
        return this;
    }
    @Step("Click on Remove key option")
    public FolderPropertiesController clickOnRemoveKey(){
        click(driver,getFolderElement(driver).removeKeyOpt);
        return this;
    }
    @Step("Select the Key : {keyName}")
    public FolderPropertiesController selectKeyName(String keyName) throws InterruptedException {
        selectElementInTable(driver,getFolderElement(driver).selectTable,keyName);
        return this;
    }

}
