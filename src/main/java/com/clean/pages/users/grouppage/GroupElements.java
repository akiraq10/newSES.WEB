package com.clean.pages.users.grouppage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupElements {
    @FindBy(id = "breadcrumb_Group_ViewUserGroup_3")
    WebElement groupBreadcrumb;
    @FindBy(id = "Actions_Type_Group_Basic")
    WebElement groupMenu;
    @FindBy(id = "Actions_Group_ViewGroupGeneral")
    WebElement groupPropertiesOpt;
   @FindBy(id = "Actions_Group_MoveGroup")
    WebElement moveGroupToFolderOpt;
    @FindBy(id = "Actions_Group_DeleteGroupConfirmed")
    WebElement deleteGroupOpt;
    @FindBy(css ="tbody[role=rowgroup]")
    WebElement groupTable;
    @FindBy(css ="input[placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(id = "Actions_Type_User_Basic")
    WebElement userMenu;
    @FindBy(id = "Actions_Type_User_Advanced")
    WebElement userAdvancedMenu;
    @FindBy(id = "Actions_User_ViewUserGeneral")
    WebElement viewPropertiesOpt;
    @FindBy(id = "Actions_User_AssignGroups")
    WebElement addUserToGroupOpt;
    @FindBy(id = "Actions_User_MoveUser")
    WebElement moveUserToFolder;
    @FindBy(id = "Actions_User_AssignKeys")
    WebElement assignKeyToUser;
    @FindBy(id = "Actions_User_ViewLogs")
    WebElement viewLogsOpt;

    @FindBy(id = "Actions_Group_RemoveUserConfirmed")
    WebElement removeUserFromGroupOpt;
    @FindBy(id = "Actions_User_DeleteUserConfirmed")
    WebElement deleteUserOpt;
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement yesOnConfirmDialogBtn;
    @FindBy(css =".alert.success")
    WebElement successAlert;
    @FindBy(id = "Actions_User_ChallengeResponse")
    WebElement challengeResponseOpt;
    @FindBy(id = "Actions_User_CheckPBConnex")
    WebElement checkPBConnexOpt;
    @FindBy(id = "Actions_User_ResetFailedLoginsConfirmed")
    WebElement resetFailedRebootLoginOpt;
    private GroupElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    static GroupElements getEle(WebDriver driver){
        return new GroupElements(driver);
    }
}
