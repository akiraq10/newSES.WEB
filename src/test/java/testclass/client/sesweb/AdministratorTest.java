package testclass.client.sesweb;

import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.configuration.ConfigurationPage.configurationPage;
import static com.clean.pages.configuration.administratormanagement.AdminPage.adminPAge;
import static com.clean.pages.configuration.administratormanagement.addnewadmin.AddNewAdminPage.addNewAdminPage;
import static com.clean.pages.configuration.administratormanagement.assignrole.AssignRolePage.assignRolePage;
import static com.clean.pages.configuration.administratormanagement.editadiminuser.ModifyAdminUserPage.modifyAdminUserPage;
import static com.clean.pages.login.LoginPage.loginPage;

public class AdministratorTest extends DriverBase {
    @Test(description = "Test case SDTC....: Add new Administrator user")
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
                .searchAdminUser(readConfigFile.idpUserName())
                .selectAdminUser(readConfigFile.idpUserName())
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
                .selectAdminUser(readConfigFile.idpUserName())
                .hoverOnAdministratorMenu()
                .clickOnViewPropertiesOpt();
        modifyAdminUserPage(driver).verify().isAdminPropertiesPageDisplay();
        modifyAdminUserPage(driver).act()
                .clickOnPermissionTab()
                .hoverOnAdministratorMenu()
                .clickOnAssignRoleOpt();
        assignRolePage(driver).verify().isSelectRolePageDisplay();
        assignRolePage(driver).act()
                .selectRole("Administrator")
                .clickOnOKBtn();
        assignRolePage(driver).verify().isAlertSuccessDisplay();
    }

}
