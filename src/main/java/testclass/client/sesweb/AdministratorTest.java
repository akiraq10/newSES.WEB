package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
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

public class AdministratorTest extends DriverBase {


    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Create new Administrator user",
            groups = {"basic","regression"})
    public void createANewAdminUser(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(driver).act()
                .fillUserID(browser+"_"+ UserData.ADMIN_USERNAME.getValue())
                .fillPWD(UserData.USER_PASSWORD.getValue())
                .selectUserType(UserData.REGULAR)
                .clickOnSaveBtn();
        addUserPage(driver).verify().verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());}

    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Add new Administrator user",
            groups = {"basic","regression"},
            dependsOnMethods = "createANewAdminUser")
    public void addNewAdministratorUser(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        configurationPage(driver).act().clickOnConfiguration()
                .clickOnAdministrator();
        adminPAge(driver).verify().isAdministratorPageDisplay();
        adminPAge(driver).act()
                .hoverOnAdministratorMenu()
                .clickOnAddNewAdminOpt();
        addNewAdminPage(driver).verify().isSelectUserPageDisplay();
        addNewAdminPage(driver).act()
                .searchAdminUser(browser+"_"+UserData.ADMIN_USERNAME.getValue())
                .selectAdminUser(browser+"_"+UserData.ADMIN_USERNAME.getValue())
                .clickOnSaveButton();
        addNewAdminPage(driver).verify().isAlertSuccessDisplay();
    }
    @Parameters({"browser","uri"})
    @Test(description = "Test case SDTC....: Assign the Admin role to an admin user",
            dependsOnMethods = "addNewAdministratorUser",
            groups = {"basic","regression"})
    public void assignAdminRoleToAdminUser(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());

        configurationPage(driver).act().clickOnConfiguration()
                .clickOnAdministrator();

        adminPAge(driver).verify().isAdministratorPageDisplay();

        adminPAge(driver).act()
                .selectAdminUser(browser+"_"+UserData.ADMIN_USERNAME.getValue())
                .hoverOnAdministratorMenu()
                .clickOnViewPropertiesOpt();

        modifyAdminUserPage(driver).verify().isAdminPropertiesPageDisplay();

        modifyAdminUserPage(driver).act()
                .clickOnPermissionTab()
                .hoverOnAdministratorMenu()
                .clickOnAssignRoleOpt();

        assignRolePage(driver).verify().isSelectRolePageDisplay();

        assignRolePage(driver).act()
                .selectRole(ADMIN_ROLE_NAME.getValue())
                .clickOnOKBtn();

        assignRolePage(driver).verify().isAlertSuccessDisplay();
    }

}
