package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.FolderData;
import com.clean.datatest.GroupData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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

    @Test(alwaysRun = true,
            description = "SDTC...: Check create new group without Description")
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
                .clickOnSaveButton();

        addGroupPage(driver).verify().isCheckAddGroupSuccess(AlertData.ALERT_SUCCESS.getValue());

    }
    @Test(description = "SDTC-....:Create new group with group name + description",
    alwaysRun = true)
    public void CreateNewGroupToTestUpdate(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
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
    @Test(description = "SDTC-26728 : Group Properties: General > Change group name",
    dependsOnMethods = "CreateNewGroupToTestUpdate")
    public void ChangeTheGroupName() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
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
                .isCheckGeneralPageDisplay();
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
                .isCheckGeneralPageDisplay();
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
                .isCheckPermissionPageDisplay();
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
                .isCheckPermissionPageDisplay();
        permissionPage(driver).act()
                .clickOnAllowPBNAutoBoot()
                .clickOnSaveBtn();
        permissionPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Test(description = "SDTC-40316 : Group Properties: Keys > Back",
            dependsOnMethods = "ChangeTheGroupName"   )
    public void VerifyBackFeatureFromKeysTab() throws InterruptedException {
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
    @Test(description = "SDTC-40317 : Group Properties: Keys > Assign key",
    dependsOnMethods = "ChangeTheGroupName")
    public void AssignKeyToGroupProperties() throws InterruptedException {
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
    @Test(description = "SDTC-40318 : Group Properties: Keys > Remove key",
    dependsOnMethods = {"AssignKeyToGroupProperties"})
    public void RemoveKeyToGroupProperties() throws InterruptedException {
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

    @Test(description = "SDTC-40319 : Group Properties: Groups > Back",
            dependsOnMethods = "ChangeTheGroupName"    )
    public void VerifyBackFeatureFromGroupsTab() throws InterruptedException {
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
    @Test(description = "SDTC-26684 : Group Properties: Groups > Assign to group",
    dependsOnMethods = "ChangeTheGroupName")
    public void AssignGroupToGroupProperties() throws InterruptedException {
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
    @Test(description = "SDTC-40320 : Group Properties: Groups > Remove from parent group",
    dependsOnMethods = "AssignGroupToGroupProperties")
    public void RemoveGroupToGroupProperties() throws InterruptedException {
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
    @Test(description = "SDTC-44654 : Group Properties: Service Provider > Assign Service Providers",
    dependsOnMethods = "ChangeTheGroupName")
    public void AssignTheSPToGroup() throws InterruptedException {
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
    @Test(description = "SDTC-44655 : Group Properties: Service Provider > Remove Service Providers",
    dependsOnMethods = "AssignTheSPToGroup")
    public void RemoveSPToGroupProperties() throws InterruptedException {
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
