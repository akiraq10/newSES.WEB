package testclass.client.sesweb;

import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.configuration.ConfigurationPage.configurationPage;
import static com.clean.pages.configuration.administratormanagement.AdminPage.adminPAge;
import static com.clean.pages.configuration.administratormanagement.addnewadmin.AddNewAdminPage.addNewAdminPage;
import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRolePage.assignRolePage;
import static com.clean.pages.configuration.administratormanagement.editadiminuser.ModifyAdminUserPage.modifyAdminUserPage;
import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.datatest.AdminRoleData.*;

public class AdministratorTest extends DriverBase {
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Add new Administrator user")
    public void addNewAdministratorUser() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
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
                .searchAdminUser(UserData.REGULAR_USERNAME.getValue())
                .selectAdminUser(UserData.REGULAR_USERNAME.getValue())
                .clickOnSaveButton();
        addNewAdminPage(driver).verify().isAlertSuccessDisplay();
    }
    @Test(description = "Test case SDTC....: Assign the Admin role to an admin user",dependsOnMethods = "addNewAdministratorUser")
    public void assignAdminRoleToAdminUser() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());

        configurationPage(driver).act().clickOnConfiguration()
                .clickOnAdministrator();

        adminPAge(driver).verify().isAdministratorPageDisplay();

        adminPAge(driver).act()
                .selectAdminUser(UserData.REGULAR_USERNAME.getValue())
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
