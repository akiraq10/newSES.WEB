package testclass.client.sesweb.grouptest;

import com.clean.datatest.FolderData;
import com.clean.datatest.GroupData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;
import static com.clean.pages.users.assignKey.AssignKeyPage.assignKeyPage;
import static com.clean.pages.users.assigngroup.AssignGroupPage.assignGroupPage;
import static com.clean.pages.users.grouppage.GroupPage.groupPage;
import static com.clean.pages.users.movetofolder.MoveToFolderPage.moveToFolderPage;
import static com.clean.pages.users.userproperties.UserPropertiesPage.userPropertiesPage;
import static com.clean.pages.users.viewauditlogs.ViewAuditLogsPage.viewAuditLogsPage;

public class ActionFromUserMenu extends DriverBase {
    @Parameters({"browser","uri"})
    @Test(  dependsOnMethods ={"AddNewRegularUser","CreateNewGroup"} ,
            description = "Test case SDTC....:Verify Assign user to Group",
            groups = {"basic","regression"})
    public void AssignUserToGroup(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .searchUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .selectExistingUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnAddUserToGroup();
        assignGroupPage(driver).act()
                .selectTheGroupToAssign(browser+"_"+GroupData.GROUP_NAME.getValue())
                .clickOnSaveBtn();
        assignGroupPage(driver).verify()
                .isCheckSuccessAlertDisplay();

    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40301 : Group > User > View Properties",
    dependsOnMethods = "AssignUserToGroup",
            groups = {"regression"})
    public void verifyUserPropertiesOfUserBelongGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverToUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).verify()
                .isCheckUserPropertiesGeneralPageDisplay();

    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-26844 : Group > User > Add user to group",
            dependsOnMethods = {"AssignUserToGroup","ChangeTheGroupName"},
            groups = {"regression"})
    public void verifyAssignUserToAnotherGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverToUserMenu()
                .clickOnAddUserToGroupOpt();
        assignGroupPage(driver).act()
                .selectTheGroupToAssign(browser+"_"+GroupData.GROUP_NAME_UPDATE.getValue())
                .clickOnSaveBtn();
        assignGroupPage(driver).verify()
                .isCheckSuccessAlertDisplay();

    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40303 : Group > User > Move to folder",
            dependsOnMethods = {"AssignUserToGroup","VerifyRenameFolder"},
            groups = {"regression"})
    public void verifyMoveUserBelongGroupToAnotherFolder(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverToUserMenu()
                .clickOnUserMoveToFolder();
        moveToFolderPage(driver).verify()
                .isCheckMoveUserToFolderPageDisplay();
        moveToFolderPage(driver).act()
                .selectFolder(browser+"_"+FolderData.FOLDER_RENAME.getValue());
        moveToFolderPage(driver).verify()
                .isCheckMoveBtnDisplay();
        moveToFolderPage(driver).act()
                .clickOnMoveBtn();
        userPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40304 : Group > User > Assign key to user",
            dependsOnMethods = {"AssignUserToGroup"},
            groups = {"regression"})
    public void verifyAssignKeyToUserBelongGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverToUserMenu()
                .clickOnAssignKeyToUserOpt();
        assignKeyPage(driver).act()
                .selectKey(FolderData.DEVICE_KEY.getValue())
                .clickOnSaveBtn();
        assignKeyPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40305 : Group > User > View logsr",
            dependsOnMethods = "AssignUserToGroup",
            groups = {"regression"})
    public void verifyAudiLogsPageOfUserBelongGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverToUserMenu()
                .clickOnViewLogsOpt();
        viewAuditLogsPage(driver).verify().isCheckViewAuditLogsPageDisplay();
    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40302 : Group > User > Delete User",
            dependsOnMethods = "verifyRemoveUserFromGroup",
            groups = {"regression"})
    public void verifyDeleteUserBelongGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());

        userPage(driver).act()
                .searchUser(browser+"_"+UserData.REMOVE_USERNAME.getValue())
                .selectExistingUser(browser+"_"+UserData.REMOVE_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnAddUserToGroup();

        assignGroupPage(driver).act()
                .selectTheGroupToAssign(browser+"_"+GroupData.GROUP_NAME.getValue())
                .clickOnSaveBtn();

        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REMOVE_USERNAME.getValue())
                .hoverToUserMenu()
                .clickOnDeleteUserOpt()
                .clickOnYesBtnOnConfirmationDialog();
        groupPage(driver).verify()
                .isCheckAlertSuccessDisplayed(GroupData.OPERATION_ALERT.getValue());

    }

    @Feature("Test Suite : Group -> Action from User menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40306 : Group > User > Remove user from group",
            dependsOnMethods = "CreateNewGroup",
            groups = {"regression"})
    public void verifyRemoveUserFromGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(browser+"_"+UserData.REMOVE_USERNAME.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .selectUserType(UserData.REGULAR)
                .clickOnSaveBtn();

        userPropertiesPage(driver).act()
                .hoverToUserMenu()
                .clickOnAddUserToGroupOpt();

        assignGroupPage(driver).act()
                .selectTheGroupToAssign(browser+"_"+GroupData.GROUP_NAME.getValue())
                .clickOnSaveBtn();

        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REMOVE_USERNAME.getValue())
                .hoverToUserMenu()
                .clickRemoveUserFromGroupOpt()
                .clickOnYesBtnOnConfirmationDialog();
        groupPage(driver).verify()
                .isCheckAlertSuccessDisplayed(GroupData.COMMAND_SUCCESS_ALERT.getValue());

    }

}
