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
    @Step("Click on the User tab")
    public FolderPropertiesController clickOnUserTab(){
        click(driver,getFolderElement(driver).usersTab);
        return this;
    }
    @Step("Click on the Assign User option")
    public FolderPropertiesController clickOnAssignUserOpt(){
        click(driver,getFolderElement(driver).assignUserOpt);
        return this;
    }
    @Step("Click on the Remove User option")
    public FolderPropertiesController clickOnRemoveUserOpt(){
        click(driver,getFolderElement(driver).removeUserOpt);
        return this;
    }
    @Step("Select the user name : {userName}")
    public FolderPropertiesController selectUserName(String userName) throws InterruptedException {
        selectElementInTable(driver,getFolderElement(driver).selectTable,userName);
        return this;
    }
    @Step("Click on the Group tab")
    public FolderPropertiesController clickOnGroupTab(){
        click(driver,getFolderElement(driver).groupTab);
        return this;
    }
    @Step("Click On Assign Group Opt")
    public FolderPropertiesController clickOnAssignGroupOpt(){
        click(driver,getFolderElement(driver).assignGroupOpt);
        return this;
    }
    @Step("Click On Remove Group Opt")
    public FolderPropertiesController clickOnRemoveGroupOpt(){
        click(driver,getFolderElement(driver).removeGroupOpt);
        return this;
    }
    @Step("Select the Group name : {groupName}")
    public FolderPropertiesController selectGroupName(String groupName) throws InterruptedException {
        selectElementInTable(driver,getFolderElement(driver).selectTable,groupName);
        return this;
    }

}
