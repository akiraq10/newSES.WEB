package com.clean.pages.users.grouppage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.grouppage.GroupElements.getEle;
import static com.clean.ults.ElementController.*;

public class GroupController {
    WebDriver driver;

     GroupController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse to Group Menu")
    public GroupController hoverToGroupMenu(){
         hover(driver,getEle(driver).groupMenu);
         return this;
    }
    @Step("Hover mouse to User Menu")
    public GroupController hoverToUserMenu(){
        hover(driver,getEle(driver).userMenu);
        return this;
    }
    @Step("Click on the Group Properties option")
    public GroupController  clickOnGroupPropertiesOpt() {
         click(driver,getEle(driver).groupPropertiesOpt);
         return this;
    }
    @Step("Click on the View Properties option")
    public GroupController  clickOnViewPropertiesOpt() {
         click(driver,getEle(driver).viewPropertiesOpt);
         return this;
    }
    @Step("Click on the Delete User(S) option")
    public GroupController  clickOnDeleteUserOpt() {
        click(driver,getEle(driver).deleteUserOpt);
        return this;
    }
    @Step("Click on the Delete Group option")
    public GroupController  clickOnDeleteGroupOpt() {
        click(driver,getEle(driver).deleteGroupOpt);
        return this;
    }
    @Step("Click on the Add user to groups option")
    public GroupController  clickOnAddUserToGroupOpt() {
         click(driver,getEle(driver).addUserToGroupOpt);
         return this;
    }
    @Step("Click on the Move To Folder option")
    public GroupController clickOnUserMoveToFolder() {
         click(driver,getEle(driver).moveUserToFolder);
         return this;
    }
    @Step("Click on the Move To Folder option")
    public GroupController clickOnGroupMoveToFolder() {
         click(driver,getEle(driver).moveGroupToFolderOpt);
         return this;
    }
    @Step("Click on the Assign Key To User option")
    public GroupController  clickOnAssignKeyToUserOpt() {
         click(driver,getEle(driver).assignKeyToUser);
         return this;
    }
    @Step("Click on the View Logs option")
    public GroupController clickOnViewLogsOpt() {
         click(driver,getEle(driver).viewLogsOpt);
         return this;
    }
    @Step("Click on the Remove User From Group option")
    public GroupController clickRemoveUserFromGroupOpt() {
         click(driver,getEle(driver).removeUserFromGroupOpt);
         return this;
    }
    @Step("Click on the Yes button on Confirm remove user from group dialog")
    public GroupController clickOnYesBtnOnConfirmationDialog() {
        click(driver,getEle(driver).yesOnConfirmDialogBtn);
        return this;
    }
    @Step("Select the user: {userName}")
    public GroupController selectUserInGroup(String userName) throws InterruptedException {
         selectElementHasLinkInTable(driver,getEle(driver).groupTable,userName);
         return this;
    }
    @Step("Hover mouse to User Advanced Menu")
    public GroupController hoverMouseToUserAdvancedMenu() {
         hover(driver,getEle(driver).userAdvancedMenu);
         return this;
    }
    @Step("Click on the Challenge Response option")
    public GroupController clickOnTheChallengeResponseOpt() {
         click(driver,getEle(driver).challengeResponseOpt);
         return this;
    }
    @Step("Click on the Check PBConnex option")
    public GroupController clickOnTheCheckPBConnexOpt() {
         click(driver,getEle(driver).checkPBConnexOpt);
         return this;
    }
    @Step("Click on the Reset Failed Preboot Login option")
    public GroupController clickOnTheResetFailedPrebootLoginOpt() {
         click(driver,getEle(driver).resetFailedRebootLoginOpt);
         return this;
    }


}
