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
    @FindBy(css ="button[class='submit']")
    WebElement saveBtn;
    @FindBy(id = "breadcrumb_Folder_ViewFolderGeneral_4")
    WebElement folderPropertiesBreadcrumb;


    
    private FolderPropertiesElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public static FolderPropertiesElements getFolderElement(WebDriver driver){
        return new FolderPropertiesElements(driver);
    }
}
