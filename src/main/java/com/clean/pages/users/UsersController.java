package com.clean.pages.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.UserElements.getUserElem;
import static com.clean.ults.ElementController.*;
import static com.clean.ults.ElementController.zoomInPage;
import static java.lang.Thread.sleep;


public class UsersController {
    private WebDriver driver ;

    public UsersController(WebDriver driver) {
        this.driver=driver;

    }

    @Step("Hover mouse on the Folder menu")
    public UsersController hoverOnFolderMenu() {

        hover(driver, getUserElem(driver).folderMenu);
        return this;
    }
    @Step("Hover mouse on the User menu")
    public UsersController hoverOnUserMenu() {

        hover(driver, getUserElem(driver).userMenu);
        return this;
    }
    @Step("Click on the Add Folder option")
    public UsersController clickOnAddFolder() {
        click(driver, getUserElem(driver).addFolderOpt);
        return this;
    }
    @Step("Click on the View Properties option")
    public UsersController clickOnViewPropertiesOpt() {
        click(driver, getUserElem(driver).viewPropertiesOpt);
        return this;
    }
    @Step("Click on the Add User option")
    public UsersController clickOnAddUser() {
        click(driver, getUserElem(driver).addUserOpt);
        return this;
    }
    @Step("Click on the Add Group option")
    public UsersController clickOnAddGroup() {
        click(driver, getUserElem(driver).addGroupOpt);
        return this;
    }
    @Step("Click on the Add User(s) to Group option")
    public UsersController clickOnAddUserToGroup() {
        click(driver, getUserElem(driver).addUserToGroupOpt);
        return this;
    }



    private UsersController clickOnExpandIcon() throws InterruptedException {
        click(driver, getUserElem(driver).expandFolderIcon);
        sleep(1000);
        return this;
    }
    @Step("Select User as {username}")
    public UsersController selectExistingUser(String username) throws InterruptedException {
        selectElementHasLinkInTable(driver,getUserElem(driver).userListTbl,username);
        return this;
    }
    @Step("Enter user: {userName} at Search textbox ")
    public UsersController searchUser(String userName){
        fill(driver,getUserElem(driver).searchText,userName);
        return this;
    }

    @Step("Select the folder as {folderName}")
    public UsersController selectFolderOnFolderTree(String folderName) throws InterruptedException {
        clickOnExpandIcon();
        selectElementInList(driver,getUserElem(driver).folderTree,folderName);
        sleep(2000);
        return this;

    }
    @Step("Click on Folder properties option")
    public UsersController clickOnFolderPropertiesOpt(){
        click(driver,getUserElem(driver).folderProperties);
        return this;
    }

    @Step("Select the folder as {groupName}")
    public UsersController selectGroupOnFolderTree(String groupName) throws InterruptedException {
        clickOnExpandIcon();
        selectElementInList(driver,getUserElem(driver).folderTree,groupName);
        sleep(2000);
        return this;

    }
    @Step("Select the folder as {groupName}")
    public UsersController selectGroupOnFolderTreeNotClickExpandIcon(String groupName) throws InterruptedException {
        selectElementInList(driver,getUserElem(driver).folderTree,groupName);
        sleep(2000);
        return this;

    }
    @Step("Click on the Log off Option at top right corner")
    public UsersController clickOnLogOff()  {
        click(driver,getUserElem(driver).logOffOpt);
        return this;
    }
}
