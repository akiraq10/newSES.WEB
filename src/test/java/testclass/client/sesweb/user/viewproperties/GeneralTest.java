package testclass.client.sesweb.user.viewproperties;

import com.clean.datatest.AlertData;
import com.clean.datatest.FolderData;
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
import static com.clean.pages.users.movetofolder.MoveToFolderPage.moveToFolderPage;
import static com.clean.pages.users.userproperties.UserPropertiesPage.userPropertiesPage;

public class GeneralTest extends DriverBase {
    String browser="chrome";
    String uri="https://messo.asia";
    @Feature("Test Suite : Users -> View Properties->General")
    @Parameters({"browser","uri"})
    @Test(  description = "SDTC-11401 : User Properties: General",
            groups = {"regression"},
            dependsOnMethods = "AddNewRegularUser")
    public void verifyAllTextFieldsInUserProperties(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectExistingUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).verify()
                .isCheckUserPropertiesGeneralPageDisplay()
                .isCheckAllFieldsDisplay();

    }

    @Feature("Test Suite : Users -> View Properties->General")
    @Parameters({"browser","uri"})
    @Test(  description = "SDTC-23526 : User Properties: General - Modify password ",
            groups = {"regression"},
            dependsOnMethods = "assignAdminRoleToAdminUser")
    public void verifyChangePWDForAdmin(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(browser+"_"+UserData.ADMIN_USERNAME.getValue(), UserData.USER_PASSWORD.getValue());
        userPage(driver).act()
                .searchUser(browser+"_"+UserData.ADMIN_USERNAME.getValue())
                .selectExistingUser(browser+"_"+UserData.ADMIN_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).act()
                .fillPassword(UserData.NEW_USER_PASSWORD.getValue())
                .clickOnSaveBtn();
        userPropertiesPage(driver).verify()
                .isCheckSuccessAlertDisplayed(AlertData.ALERT_SUCCESS.getValue());
        userPage(driver).act()
               .clickOnLogOff();
        loginPage(driver).act()
                .loginSESWEB(browser+"_"+UserData.ADMIN_USERNAME.getValue(), UserData.NEW_USER_PASSWORD.getValue());

    }
    @Feature("Test Suite : Users -> View Properties->General")
    @Parameters({"browser","uri"})
    @Test(  description = "SDTC-11402 : User Properties: General - Modify info",
            groups = {"regression"},
            dependsOnMethods = "AddNewRegularUser")
    public void verifyTheUserInfo(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectExistingUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).act()
                .fillDescription(UserData.DESCRIPTION_UPDATE.getValue())
                .clickOnSaveBtn();
        userPropertiesPage(driver).verify()
                .isCheckSuccessAlertDisplayed(AlertData.ALERT_SUCCESS.getValue())
                .isCheckDescription(UserData.DESCRIPTION_UPDATE.getValue());
    }

    @Feature("Test Suite : Users -> View Properties->General")
    @Parameters({"browser","uri"})
    @Test(  description = "SDTC-40231 : User Properties: General - Delete User",
            groups = {"regression"}
            )
    public void verifyDeleteAUserInUSerProperties(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(browser+"_"+UserData.DELETE_USERNAME.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .clickOnSaveBtn();
        addUserPage(driver).verify()
                        .verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
        userPage(driver).act()
                .clickOnTheRootFolder()
                .searchUser(browser+"_"+UserData.DELETE_USERNAME.getValue())
                .selectExistingUser(browser+"_"+UserData.DELETE_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).act()
                .hoverToUserMenu()
                .clickOnDeleteUserOpt()
                .clickOnYesBtnOnConfirmation();
        userPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Feature("Test Suite : Users -> View Properties->General")
    @Parameters({"browser","uri"})
    @Test(  description = "SDTC-40232 : User Properties: General - Move to Folder",
            groups = {"regression"},
            dependsOnMethods = "addNewRegularUserWithFinalPassword")
    public void verifyMoveUserToAnotherFolder(String browser, String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .searchUser(browser+"_"+UserData.REGULAR_USERNAME2.getValue())
                .selectExistingUser(browser+"_"+UserData.REGULAR_USERNAME2.getValue())
                .hoverOnUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).act()
                .hoverToUserMenu()
                .clickOnMoveToFolderOption();
        moveToFolderPage(driver).act()
                .selectFolder(browser+"_"+ UserData.FOLDER_NAME.getValue())
                .clickOnMoveBtn();
        userPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Feature("Test Suite : Users -> View Properties->General")
    @Parameters({"browser","uri"})
    @Test(  description = "SDTC-40233 : User Properties: General - Assign key to user ",
            groups = {"regression"},
            dependsOnMethods = "AddNewRegularUser")
    void verifyAssignKeyToUser(String browser, String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .searchUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .selectExistingUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .hoverOnUserMenu()
                .clickOnViewPropertiesOpt();
        userPropertiesPage(driver).act()
                .hoverToUserMenu()
                .clickOnAssignKeyToUserOption();
        assignKeyPage(driver).act()
                .selectKey(FolderData.DEVICE_KEY.getValue())
                .clickOnSaveBtn();
        userPropertiesPage(driver).verify()
                .isCheckSuccessAlertDisplayed(AlertData.ALERT_SUCCESS.getValue());
    }


}
