package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.edituser.EditUserPage.editUserPage;

public class UsersTest extends DriverBase {

    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify create new regular user success",
            groups = {"basic","regression"})
    public void AddNewRegularUser(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
        addUserPage(driver).verify().verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify can create new regular user with final password",
            groups = {"basic","regression"})
    public void AddNewRegularUserWithFinalPassowrd(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
        addUserPage(driver).verify().verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify can create new temporary user success",
            groups = {"basic","regression"})
    public void AddNewTempUser(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
        addUserPage(driver).verify().verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify can create new  Autoboot user success ",
            groups = {"basic","regression"})
    public void AddNewAutoBootUser(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(UserData.AUTO_USERNAME.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .selectUserType(UserData.AUTO)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....:Verify admin can add email for an existing user",
            groups = {"basic","regression"})
    public void ModifyUserAddEmail(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act().selectExistingUser(UserData.REGULAR_USERNAME.getValue());
        editUserPage(driver).act().fillEmail(readConfigFile.idPEmailUser())
                .clickOnSaveBtn();
        editUserPage(driver).verify().isAlertSuccessDisplay();
    }

}
