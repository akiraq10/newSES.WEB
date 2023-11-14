package testclass.client.sesweb;

import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import static com.clean.pages.users.addfolder.AddFolderPage.addFolderPage;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.edituser.EditUserPage.editUserPage;

public class UsersTest extends DriverBase {


//    public void initial() {
//        WebDriver driver;
//        driver = getDriver();
//        driver.get(readConfigFile.urlSESWEB());
//    }
    @Test(alwaysRun = true,description = "Test case SDTC-... : Verify can create new folder success")
    public void AddNewFolder() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(UserData.REGULAR_USERNAME.toString())
                .fillDescription("aaaa2")
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(readConfigFile.alertSuccess());

    }
    @Test(alwaysRun = true,description = "Test case SDTC....: Verify create new regular user success")
    public void AddNewRegularUser(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(UserData.REGULAR_USERNAME.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .selectUserType(UserData.REGULAR)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(alwaysRun = true,description = "Test case SDTC....: Verify can create new regular user with final password")
    public void AddNewRegularUserWithFinalPassowrd(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(UserData.REGULAR_USERNAME2.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .selectUserType(UserData.REGULAR)
                .unCheckFinalPassword()
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(alwaysRun = true,description = "Test case SDTC....: Verify can create new temporary user success")
    public void AddNewTempUser(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(UserData.TEMPORARY_USERNAME.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .selectUserType(UserData.TEMPORARY)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(alwaysRun = true,description = "Test case SDTC....: Verify can create new  Autoboot user success ")
    public void AddNewAutoBootUser(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(UserData.AUTO_USERNAME.getValue())
                .fillPWD("qwe")
                .selectUserType(UserData.AUTO)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(description = "Test case SDTC....:Verify admin can add email for an existing user")
    public void ModifyUserAddEmail() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act().selectExistingUser(readConfigFile.idpUserName());
        editUserPage(driver).act().fillEmail(readConfigFile.idPEmailUser())
                .clickOnSaveBtn();
        editUserPage(driver).verify().isAlertSuccessDisplay();
    }

}
