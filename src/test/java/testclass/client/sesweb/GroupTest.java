package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.FolderData;
import com.clean.datatest.GroupData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;

import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.addgroup.AddGroupPage.addGroupPage;
import static com.clean.pages.users.assignKey.AssignKeyPage.assignKeyPage;
import static com.clean.pages.users.assigngroup.AssignGroupPage.assignGroupPage;
import static com.clean.pages.users.assignserviceprovider.AssignSPPage.assignSPPage;
import static com.clean.pages.users.grouppage.GroupPage.groupPage;
import static com.clean.pages.users.groupproperties.GroupPropertiesPage.groupPropertiesPage;
import static com.clean.pages.users.grouppropertiespermission.PermissionPage.permissionPage;

public class GroupTest extends DriverBase {

    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "SDTC...: Check create new group without Description",
            groups = {"basic","regression"})
    public void CreateNewGroup(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());

        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddGroup();

        addGroupPage(driver).act()
                .fillGroupName(GroupData.GROUP_NAME.getValue())
                .clickOnSaveButton();

        addGroupPage(driver).verify().isCheckAddGroupSuccess(AlertData.ALERT_SUCCESS.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-....:Create new group with group name + description",
    alwaysRun = true,
            groups = {"basic","regression"})
    public void CreateNewGroupToTestUpdate(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());

        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddGroup();

        addGroupPage(driver).act()
                .fillGroupName(GroupData.GROUP_NAME_TEST_UPDATE.getValue())
                .fillDescription(GroupData.GROUP_DESCRIPTION.getValue())
                .clickOnSaveButton();

        addGroupPage(driver).verify().isCheckAddGroupSuccess(AlertData.ALERT_SUCCESS.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-26728 : Group Properties: General > Change group name",
    dependsOnMethods = "CreateNewGroupToTestUpdate",
            groups = {"regression"})
    public void ChangeTheGroupName(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(GroupData.GROUP_NAME_TEST_UPDATE.getValue());
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_TEST_UPDATE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();
        groupPropertiesPage(driver).verify()
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .enterGroupName(GroupData.GROUP_NAME_UPDATE.getValue())
                .clickOnSaveBtn();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40311 : Group Properties: General > Change Description",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void ChangeTheDescription(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .enterGroupDescription(GroupData.GROUP_DESCRIPTION_UPDATE.getValue())
                .clickOnSaveBtn();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40312 : Group Properties: General > Back",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void VerifyBackFeatureFromGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGeneralMenu()
                .clickOnBackOption();
        groupPage(driver).verify()
                .isCheckGroupPageDisplay(GroupData.GROUP_NAME_UPDATE.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40313 : Group Properties: Permissions > Back",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void VerifyBackFeatureFromPermissionTab(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnPermissionTab();
        groupPropertiesPage(driver).verify()
                .isCheckPermissionPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGeneralMenu()
                .clickOnBackOption();
        groupPropertiesPage(driver).verify()
                .isCheckGeneralPageDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40314 : Group Properties: Permissions > Edit Privileges",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void EditPermissionOfGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckPermissionPageDisplay();
        permissionPage(driver).act()
                .clickOnModifyProfile()
                .clickOnModifyKey()
                .clickOnSaveBtn();
        permissionPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40315 : Group Properties: Permissions > Edit PBConnex policies (e.g: PBN AutoBoot",
            dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void EditPBNPolicyOfGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckPermissionPageDisplay();
        permissionPage(driver).act()
                .clickOnAllowPBNAutoBoot()
                .clickOnSaveBtn();
        permissionPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40316 : Group Properties: Keys > Back",
            dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void VerifyBackFeatureFromKeysTab(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnKeysTab();
        groupPropertiesPage(driver).verify()
                .isCheckKeyPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGeneralMenu()
                .clickOnBackOption();
        groupPropertiesPage(driver).verify()
                .isCheckGeneralPageDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40317 : Group Properties: Keys > Assign key",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void AssignKeyToGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnKeysTab()
                .hoverToGroupMenu()
                .clickOnAssignKeyOpt();
        assignKeyPage(driver).act()
                .selectKey(FolderData.DEVICE_KEY.getValue())
                .clickOnSaveBtn();
        assignKeyPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40318 : Group Properties: Keys > Remove key",
    dependsOnMethods = {"AssignKeyToGroupProperties"},
            groups = {"regression"})
    public void RemoveKeyToGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnKeysTab()
                .selectKeyNameInTable(FolderData.DEVICE_KEY.getValue())
                .hoverToGroupMenu()
                .clickOnRemoveKeyOpt();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay()
                .isCheckKeyIsRemoved(FolderData.DEVICE_KEY.getValue());
    }

    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40319 : Group Properties: Groups > Back",
            dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void VerifyBackFeatureFromGroupsTab(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnGroupTab();
        groupPropertiesPage(driver).verify()
                .isCheckGroupsPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGeneralMenu()
                .clickOnBackOption();
        groupPropertiesPage(driver).verify()
                .isCheckGeneralPageDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-26684 : Group Properties: Groups > Assign to group",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void AssignGroupToGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnGroupTab();
        groupPropertiesPage(driver).verify()
                .isCheckGroupsPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGroupMenu()
                .clickOnAssignGroup();
        assignGroupPage(driver).act()
                .clickOnTheGroup(GroupData.GROUP_NAME.getValue())
                .clickOnSaveBtn();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40320 : Group Properties: Groups > Remove from parent group",
    dependsOnMethods = "AssignGroupToGroupProperties",
            groups = {"regression"})
    public void RemoveGroupToGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnGroupTab();
        groupPropertiesPage(driver).verify()
                .isCheckGroupsPageDisplay();
         groupPropertiesPage(driver).act()
                .selectGroupNameInTable(GroupData.GROUP_NAME.getValue())
                .hoverToGroupMenu()
                .clickOnRemoveGroup()
                .clickOnYesBtnOnConfirmationDialog();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay()
                .isCheckGroupIsRemoved(GroupData.GROUP_NAME.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-44654 : Group Properties: Service Provider > Assign Service Providers",
    dependsOnMethods = "ChangeTheGroupName",
            groups = {"regression"})
    public void AssignTheSPToGroup(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnSPTab();
        groupPropertiesPage(driver).verify()
                .isCheckServiceProviderPageDisplay();
        groupPropertiesPage(driver).act()
                .hoverToGroupMenu()
                .clickOnTheAssignSPOpt();
        assignSPPage(driver).verify()
                .isCheckAssignSPPageDisplay();
        assignSPPage(driver).act()
                .selectTheSPName(GroupData.GROUP_SERVICE_PROVIDER_NAME.getValue())
                .clickOnSaveBtn();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-44655 : Group Properties: Service Provider > Remove Service Providers",
    dependsOnMethods = "AssignTheSPToGroup",
            groups = {"regression"})
    public void RemoveSPToGroupProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
                .isCheckGeneralPageDisplay();
        groupPropertiesPage(driver).act()
                .clickOnSPTab();
        groupPropertiesPage(driver).verify()
                .isCheckServiceProviderPageDisplay();
        groupPropertiesPage(driver).act()
                .selectSPInTable(GroupData.GROUP_SERVICE_PROVIDER_NAME.getValue())
                .hoverToGroupMenu()
                .clickOnTheRemoveSPOpt();
        groupPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay()
                .isCheckSPIsRemoved(GroupData.GROUP_SERVICE_PROVIDER_NAME.getValue());

    }



}
