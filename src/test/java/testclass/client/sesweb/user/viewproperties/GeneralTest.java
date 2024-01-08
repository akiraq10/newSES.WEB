package testclass.client.sesweb.user.viewproperties;

import com.clean.datatest.AlertData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.datatest.AdminRoleData.ADMIN_ROLE_NAME;
import static com.clean.pages.configuration.ConfigurationPage.configurationPage;
import static com.clean.pages.configuration.administratormanagement.AdminPage.adminPAge;
import static com.clean.pages.configuration.administratormanagement.addnewadmin.AddNewAdminPage.addNewAdminPage;
import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRolePage.assignRolePage;
import static com.clean.pages.configuration.administratormanagement.editadiminuser.ModifyAdminUserPage.modifyAdminUserPage;
import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;
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
}
