package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.FolderData;
import com.clean.datatest.GroupData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.addfolder.AddFolderPage.addFolderPage;
import static com.clean.pages.users.assignKey.AssignKeyPage.assignKeyPage;
import static com.clean.pages.users.assigngroup.AssignGroupPage.assignGroupPage;
import static com.clean.pages.users.assignuser.AssignUserPage.assignUserPage;
import static com.clean.pages.users.folderproperties.FolderPropertiesPage.folderPropertiesPage;

public class FolderTest extends DriverBase {
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC-... : Verify can create new folder success",
            groups = {"basic","regression"})
    public void AddNewFolder(String browser,String uri) throws  MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(browser+"_"+UserData.FOLDER_NAME.getValue())
                .fillDescription(UserData.DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,description = "SDTC-41715 : Create folder name containing 1 char ",
            groups = {"regression"})
    public void AddNewFolderWithOneChar(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();

        switch (browser) {
            case "chrome":
                addFolderPage(driver).act()
                        .fillFolderName(FolderData.FOLDER_1_CHAR_GG.getValue());
                break;
            case "firefox":
                addFolderPage(driver).act()
                        .fillFolderName(FolderData.FOLDER_1_CHAR_FF.getValue());
                break;
            default:
                System.out.println(browser +" NOT available" );
                break;
        }

        addFolderPage(driver).act()
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "SDTC-38626 : Check Extend icon on folder tree in SESWeb",
            groups = {"regression"})
    public void CheckExtendIconOnFolderTree(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).verify().isCheckExtendIconOnFolderTree();
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "SDTC-40400 : Not allow to create folder with name over 64 chars",
            groups = {"regression"})
    public void CreateNewFolderWith64Character(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(FolderData.FOLDER_64_CHAR.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().isCheckAlertDeniedDisplay(AlertData.ALERT_64_CHARACTERS.getValue());
    }

    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40294 : Folder Properties - General > Back",
            dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void SelectFolderAndGotoFolderProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnGeneralMenu()
                .clickOnBackOption();
        userPage(driver).verify()
                .isCheckUserBreadcrumbDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(
            description = "SDTC-38627 : Folder Properties - Folder > Add Folder",
            dependsOnMethods = "AddNewFolder",
            groups = {"regression"}
    )
    public void addNewFolderInFolderProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolderOpt()
                .fillFolderName(browser+"_"+FolderData.FOLDER_SUB.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-38628 : Folder Properties - Folder > Add new Group",
    dependsOnMethods = "AddNewFolder",
            groups = {"regression"}
    )
    public void addNewGroupInFolderProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddNewGroupOpt()
                .fillGroupName(browser+"_"+FolderData.GROUP_SUB.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-40296 : Folder Properties - Folder > Add new user",
    dependsOnMethods = "AddNewFolder",
            groups = {"regression"}
    )
    public void addNewUserInFolderProperties(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddNewUserOpt()
                .fillUserID(browser+"_"+FolderData.USER_SUB.getValue())
                .fillPassword(FolderData.PASSWORD_USER_SUB.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-40295 : Folder Properties - Folder > Challenge Response",
    dependsOnMethods = "AddNewFolder",
            groups = {"regression"}
    )
        public void verifyRMCEChallengeResponse(String browser,String uri) throws InterruptedException, MalformedURLException {
            WebDriver driver;
            driver = getDriver(browser);
            driver.get(uri);
            loginPage(driver).act()
                    .loginSESWEB(readConfigFile.username(), readConfigFile.password());
            userPage(driver).act()
                    .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                    .hoverOnFolderMenu()
                    .clickOnFolderPropertiesOpt();
            folderPropertiesPage(driver).verify()
                    .isCheckFolderPropertiesBreadcrumbDisplay();
            folderPropertiesPage(driver).act()
                    .hoverOnFolderMenu()
                    .clickOnChallengeResponseOpt();
            folderPropertiesPage(driver).verify()
                    .isCheckRmceChallengeResponseDisplay(FolderData.RMCE_CHALLENGE_TITLE.getValue())
                    .isCheckChallengeResponsePageDisplay()
                    .isCheckGetResponseBtnDisplay();
        }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
    description = "SDTC-38642 : Folder Properties - Folder > Delete folder",
            groups = {"regression"})
    public void DeleteFolderInFolderP(String browser,String uri) throws  MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(browser+"_"+FolderData.FOLDER_DELETE.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickDeleteFolderOpt();
        folderPropertiesPage(driver).verify()
                .isCheckDeleteFolderConfirmDisplay()
                .isCheckDeleteMsgInConfirmationDialog(FolderData.DELETE_FOLDER_CONFIRM.getValue());
        folderPropertiesPage(driver).act()
                .clickOnYesBtnOnConfirmDialog();
        folderPropertiesPage(driver).verify()
                .isCheckDeleteMsgSuccess(FolderData.DELETE_FOLDER_SUCCESS_MSG.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-40297 : Folder Properties - Folder > View logs",
    dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void VerifyViewLogPage(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnViewLog();
        folderPropertiesPage(driver).verify()
                .isCheckViewLogPageDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-38630 : Folder properties - Folder Name",
    dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void VerifyTheFolderNameAfterCreatedSuccess(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay()
                .isCheckFolderNameInProperties(browser+"_"+UserData.FOLDER_NAME.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
    description = "SDTC-38631 : Folder properties - Description",
            groups = {"regression"}
    )
    public void VerifyTheDescriptionAfterCreatedSuccess(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay()
                .isCheckDescription(UserData.DESCRIPTION.getValue());

    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
    description = "SDTC-40443 : Folder properties - Folder Name - Rename",
            groups = {"regression"})
    public void VerifyRenameFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(browser+"_"+FolderData.FOLDER_NEW.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+FolderData.FOLDER_NEW.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).act()
                .fillFolderName(browser+"_"+FolderData.FOLDER_RENAME.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }
    @Parameters({"browser","uri"})
    @Test(
            description = "SDTC-38632 : Folder properties - Keys - Assign key",
            dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void AssignKeyToFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickKeyTab()
                .hoverOnFolderMenu()
                .clickOnAssignKey();
        assignKeyPage(driver).verify()
                .isCheckAssignKeyPageDisplay();
        assignKeyPage(driver).act()
                .selectKey(FolderData.DEVICE_KEY.getValue())
                .clickOnSaveBtn();
        assignKeyPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }
    @Parameters({"browser","uri"})
    @Test(
            description = "SDTC-38633 : Folder properties - Keys - Remove key",
            dependsOnMethods = "AssignKeyToFolder",
            groups = {"regression"})
    public void RemoveKeyInFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickKeyTab()
                .selectKeyName(FolderData.DEVICE_KEY.getValue())
                .hoverOnFolderMenu()
                .clickOnRemoveKey();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay()
                .isCheckKeyIsRemoved(FolderData.DEVICE_KEY.getValue());
    }
    @Parameters({"browser","uri"})
    @Test(
            description = "SDTC-40298 : Folder properties - Keys - Back",
            dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void VerifyBackFeatureInKeyTab(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickKeyTab();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesKeyBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnGeneralMenu()
                .clickOnBackOption();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
    }

    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-38635 : Folder properties - Users - Assign user",
    dependsOnMethods ={"AddNewFolder","AddNewRegularUser"} ,
            groups = {"regression"})
    public void AssignUserToFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickOnUserTab()
                .hoverOnFolderMenu()
                .clickOnAssignUserOpt();
        assignUserPage(driver).verify()
                .isCheckAssignUserPageDisplay();
        assignUserPage(driver).act()
                .selectUser(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }

    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-38636 : Folder properties - Users - Remove user",
    dependsOnMethods = "AssignUserToFolder",
            groups = {"regression"})
    public void RemoveUserFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickOnUserTab()
                .selectUserName(browser+"_"+UserData.REGULAR_USERNAME.getValue())
                .hoverOnFolderMenu()
                .clickOnRemoveUserOpt();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay()
                .isCheckUserIsRemoved(browser+"_"+UserData.REGULAR_USERNAME.getValue());


    }
    @Parameters({"browser","uri"})
    @Test(
            description = "SDTC-40299 : Folder properties - Users - Back",
          dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void VerifyBackFeatureInUserTab(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickOnUserTab();
        folderPropertiesPage(driver).verify()
                .isCheckUserPageDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnGeneralMenu()
                .clickOnBackOption();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
    }
    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-38641 : Folder properties - Groups - Assign group",
    dependsOnMethods = {"AddNewFolder","CreateNewGroup"},
            groups = {"regression"})
    public void AssignGroupToFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickOnGroupTab()
                .hoverOnFolderMenu()
                .clickOnAssignGroupOpt();
        assignGroupPage(driver).verify()
                .isCheckAssignGroupPageDisplay();
        assignGroupPage(driver).act()
                .clickOnTheGroup(browser+"_"+GroupData.GROUP_NAME.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-38640 : Folder properties - Groups - Remove group",
    dependsOnMethods = "AssignGroupToFolder",
            groups = {"regression"})
    public void RemoveGroupToFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickOnGroupTab()
                .selectGroupName(browser+"_"+GroupData.GROUP_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnRemoveGroupOpt();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay()
                .isCheckGroupIsRemoved(browser+"_"+GroupData.GROUP_NAME.getValue());
    }

    @Parameters({"browser","uri"})
    @Test(
    description = "SDTC-40300 : Folder properties - Groups - Back",
    dependsOnMethods = "AddNewFolder",
            groups = {"regression"})
    public void VerifyBackFeatureAtGroupTab(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(browser+"_"+UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .clickOnGroupTab();
        folderPropertiesPage(driver).verify()
                .isCheckGroupPageDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnGeneralMenu()
                .clickOnBackOption();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
    }

}
