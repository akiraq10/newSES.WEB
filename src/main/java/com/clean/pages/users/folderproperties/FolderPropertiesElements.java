package com.clean.pages.users.folderproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FolderPropertiesElements {
    @FindBy(id = "Actions_Type_General")
    WebElement generalMEnu;
    @FindBy(id = "Actions_Type_Folder_Basic")
    WebElement folderMenu;
    @FindBy(linkText = "Back")
    WebElement backOpt;
    @FindBy(id = "Actions_Folder_AddFolder")
    WebElement addFolderOpt;
    @FindBy(id = "Actions_Group_AddGroup")
    WebElement addNewGroupOpt;
    @FindBy(id = "Actions_Folder_AddUserGeneral")
    WebElement addNewUserOpt;
    @FindBy(id = "Actions_User_ChallengeResponseGen")
    WebElement challengeResponseOpt;
    @FindBy(id = "Actions_Folder_DeleteFolderConfirmed")
    WebElement deleteFolderOpt;
    @FindBy(id = "Actions_Folder_ViewLogs")
    WebElement viewLogsOpt;
    @FindBy(id = "tabs_Admin_0")
    WebElement generalTab;
    @FindBy(id = "tabs_Folder_1")
    WebElement keysTab;
    @FindBy(id = "tabs_Folder_2")
    WebElement usersTab;
    @FindBy(id = "tabs_Folder_3")
    WebElement groupTab;
    @FindBy(id = "Folder_Name")
    WebElement folderNameTxt;
    @FindBy(id = "Description")
    WebElement descriptionTxt;
    @FindBy(css ="button[name='save']")
    WebElement saveBtn;
    @FindBy(id = "breadcrumb_Folder_ViewFolderGeneral_4")
    WebElement folderPropertiesBreadcrumb;
    @FindBy(id = "breadcrumb_Folder_ViewFolderKeys_4")
    WebElement folderPropertiesKeyBreadcrumb;
    @FindBy(css ="[class='alert success']")
    WebElement alertSuccess;
    @FindBy(id = "GroupName")
    WebElement groupNameTxt;
    @FindBy(id = "User_Name")
    WebElement userIDTxt;
    @FindBy(css =":is(#password-input,#User_Password)")
    WebElement passwordTxT;
    @FindBy(id = "breadcrumb_User_ChallengeResponseGen_3")
    WebElement challengeResponseBreadcrumb;
    @FindBy(css ="[for='Challenge_Response']")
    WebElement challengeResponseTitle;
    @FindBy(id = "submit_button")
    WebElement getResponseBtn;
    @FindBy(css =".jconfirm-content")
    WebElement deleteFolderConfirmDialog;
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement yesBtnOnConfirmDialog;
    @FindBy(xpath = "//button[text()='No']")
    WebElement noBtnOnConfirmDialog;
    @FindBy(id = "breadcrumb_Folder_ViewLogs_4")
    WebElement viewAuditLogBreadcrumb;
    @FindBy(id = "Actions_Folder_AssignKey")
    WebElement assignKeyOpt;
    @FindBy(id = "Actions_Folder_RemoveKey")
    WebElement removeKeyOpt;
    @FindBy(css ="table[data-role='selectable']")
    WebElement selectTable;
    @FindBy(id = "Actions_Folder_AssignUser")
    WebElement assignUserOpt;
    @FindBy(id = "Actions_Folder_RemoveUser")
    WebElement removeUserOpt;
    @FindBy(id = "breadcrumb_Folder_ViewFolderUsers_4")
    WebElement folderPropertiesUserBreadcrumb;
    @FindBy(id = "breadcrumb_Folder_ViewFolderGroups_4")
    WebElement folderPropertiesGroupBreadcrumb;
    @FindBy(id = "Actions_Folder_AssignGroup")
    WebElement assignGroupOpt;
    @FindBy(id = "Actions_Folder_RemoveGroup")
    WebElement removeGroupOpt;



    
    private FolderPropertiesElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public static FolderPropertiesElements getFolderElement(WebDriver driver){
        return new FolderPropertiesElements(driver);
    }
}
