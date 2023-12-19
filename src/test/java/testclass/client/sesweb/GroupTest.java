package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.GroupData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;

import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.addgroup.AddGroupPage.addGroupPage;
import static com.clean.pages.users.grouppage.GroupPage.groupPage;
import static com.clean.pages.users.groupproperties.GroupPropertiesPage.groupPropertiesPage;
import static com.clean.pages.users.grouppropertiespermission.PermissionPage.permissionPage;

public class GroupTest extends DriverBase {
    @Description("Test case ID:")
    @Test(alwaysRun = true,
            description = " Test Case ID...: Check create new group with valid data success")
    public void CreateNewGroup(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());

        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddGroup();

        addGroupPage(driver).act()
                .fillGroupName(GroupData.GROUP_NAME.getValue())
                .fillDescription(GroupData.GROUP_DESCRIPTION.getValue())
                .clickOnSaveButton();

        addGroupPage(driver).verify().isCheckAddGroupSuccess(AlertData.ALERT_SUCCESS.getValue());

    }
    @Test(description = "SDTC-26728 : Group Properties: General > Change group name",
    dependsOnMethods = "CreateNewGroup")
    public void ChangeTheGroupName() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .enterGroupName(GroupData.GROUP_NAME_UPDATE.getValue())
                .clickOnSaveBtn();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }
    @Test(description = "SDTC-40311 : Group Properties: General > Change Description",
    dependsOnMethods = "ChangeTheGroupName")
    public void ChangeTheDescription() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .enterGroupDescription(GroupData.GROUP_DESCRIPTION_UPDATE.getValue())
                .clickOnSaveBtn();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }
    @Test(description = "SDTC-40312 : Group Properties: General > Back",
    dependsOnMethods = "ChangeTheGroupName")
    public void VerifyBackFeatureFromGroupProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGeneralMenu()
                .clickOnBackOption();
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
    }
    @Test(description = "SDTC-40313 : Group Properties: Permissions > Back",
    dependsOnMethods = "ChangeTheGroupName")
    public void VerifyBackFeatureFromPermissionTab() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnPermissionTab();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesPermissionPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGeneralMenu()
                .clickOnBackOption();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesGeneralPageDisplay();

    }
    @Test(description = "SDTC-40314 : Group Properties: Permissions > Edit Privileges",
    dependsOnMethods = "ChangeTheGroupName")
    public void EditPermissionOfGroupProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).act()
                .clickOnPermissionTab();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesPermissionPageDisplay();
        permissionPage(driver).act()
                .clickOnModifyProfile()
                .clickOnModifyKey()
                .clickOnSaveBtn();
        permissionPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Test(description = "SDTC-40315 : Group Properties: Permissions > Edit PBConnex policies (e.g: PBN AutoBoot",
            dependsOnMethods = "ChangeTheGroupName"   )
    public void EditPBNPolicyOfGroupProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).act()
                .clickOnPermissionTab();
        groupPropertiesPage(driver).verify()
                .isCheckGroupPropertiesPermissionPageDisplay();
        permissionPage(driver).act()
                .clickOnAllowPBNAutoBoot()
                .clickOnSaveBtn();
        permissionPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

}
