package com.clean.pages.users.folderproperties;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.folderproperties.FolderPropertiesElements.getFolderElement;
import static com.clean.ults.ElementController.*;

public class FolderPropertiesVerifier {
    private WebDriver driver;

    public FolderPropertiesVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the folder properties -> Properties: General page is displayed")
    public FolderPropertiesVerifier isCheckFolderPropertiesBreadcrumbDisplay(){
        verify(driver,getFolderElement(driver).folderPropertiesBreadcrumb);
        return this;
    }
    @Step("Verify the folder properties -> Properties: Keys page is displayed")
    public FolderPropertiesVerifier isCheckFolderPropertiesKeyBreadcrumbDisplay(){
        verify(driver,getFolderElement(driver).folderPropertiesKeyBreadcrumb);
        return this;
    }
    @Step("Verify the Alert success is displayed")
    public FolderPropertiesVerifier isCheckAlertSuccessDisplay(){
        verify(driver,getFolderElement(driver).alertSuccess);
        return this;
    }
    @Step("Verify the {title} breadcrumb is displayed")
    public FolderPropertiesVerifier isCheckRmceChallengeResponseDisplay(String title){
        verify(driver,getFolderElement(driver).challengeResponseBreadcrumb,title);
        return this;

    }
    @Step("Verify the Challenge Response is displayed")
    public FolderPropertiesVerifier isCheckChallengeResponsePageDisplay(){
        verify(driver,getFolderElement(driver).challengeResponseTitle);
        return this;

    } @Step("Verify the get response button is displayed")
    public FolderPropertiesVerifier isCheckGetResponseBtnDisplay(){
        verify(driver,getFolderElement(driver).getResponseBtn);
        return this;

    }
    @Step("Verify the delete folder confirmation dialog is displayed")
    public FolderPropertiesVerifier isCheckDeleteFolderConfirmDisplay() {
        verify(driver,getFolderElement(driver).deleteFolderConfirmDialog);
        return this;
    }
    @Step("Verify the {message} message in the delete folder confirmation dialog")
    public FolderPropertiesVerifier isCheckDeleteMsgInConfirmationDialog(String message) {
        verify(driver,getFolderElement(driver).deleteFolderConfirmDialog,message);
        return this;
    }
    @Step("Verify the {message} message in the delete folder confirmation dialog")
    public FolderPropertiesVerifier isCheckDeleteMsgSuccess(String message) {
        verify(driver,getFolderElement(driver).alertSuccess,message);
        return this;
    }
    @Step("Verify the View log page is displayed")
    public FolderPropertiesVerifier isCheckViewLogPageDisplay() {
        verify(driver,getFolderElement(driver).viewAuditLogBreadcrumb);
        return this;
    }
    @Step("Verify the folder name {folderName}")
    public FolderPropertiesVerifier isCheckFolderNameInProperties(String folderName) {
        verifyTextInElement(driver,getFolderElement(driver).folderNameTxt,folderName);
        return this;
    }
    @Step("Verify the Description {description}")
    public FolderPropertiesVerifier isCheckDescription(String description) {
        verifyTextInElement(driver,getFolderElement(driver).descriptionTxt,description);
        return this;
    }
    @Step("Verify the username {username} is removed in folder success")
    public FolderPropertiesVerifier isCheckUserIsRemoved(String username) throws InterruptedException {
        verifyElementNotDisplayInTable(driver,getFolderElement(driver).selectTable,username);
        return this;
    }
    @Step("Verify the username {userName} is removed in folder success")
    public FolderPropertiesVerifier isCheckKeyIsRemoved(String userName) throws InterruptedException {
        verifyElementNotDisplayInTable(driver,getFolderElement(driver).selectTable,userName);
        return this;
    }
    @Step("Verify the Users Page is displayed")
    public FolderPropertiesVerifier isCheckUserPageDisplay()
    {
        verify(driver,getFolderElement(driver).folderPropertiesUserBreadcrumb);
        return this;
    }
    @Step("Verify the Group Page is displayed")
    public FolderPropertiesVerifier isCheckGroupPageDisplay()
    {
        verify(driver,getFolderElement(driver).folderPropertiesGroupBreadcrumb);
        return this;
    }
    @Step("Verify the Group:  {groupName} is removed in folder success")
    public FolderPropertiesVerifier isCheckGroupIsRemoved(String groupName) throws InterruptedException {
        verifyElementNotDisplayInTable(driver,getFolderElement(driver).selectTable,groupName);
        return this;
    }

}
