package testclass.client.sesweb;

import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import static com.clean.pages.users.addfolder.AddFolderPage.addFolderPage;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.login.LoginPage.loginPage;

public class UsersTest extends DriverBase {


//    public void initial() {
//        WebDriver driver;
//        driver = getDriver();
//        driver.get(readConfigFile.urlSESWEB());
//    }
    @Test(alwaysRun = true)
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
    @Test(alwaysRun = true)
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
                .fillUserID("Regular User333")
                .fillPWD("qwe")
                .selectUserType(UserData.REGULAR)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(alwaysRun = true)
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
                .fillUserID("Regular User3333")
                .fillPWD("qwe")
                .selectUserType(UserData.REGULAR)
                .unCheckFinalPassword()
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(alwaysRun = true)
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
                .fillUserID("Temporary User1333")
                .fillPWD("qwe")
                .selectUserType(UserData.TEMPORARY)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }
    @Test(alwaysRun = true)
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
                .fillUserID("Autoboot User1333")
                .fillPWD("qwe")
                .selectUserType(UserData.AUTO)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(readConfigFile.alertSuccess());
    }

}
