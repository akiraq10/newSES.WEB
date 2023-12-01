package testclass.client.sesweb;

import com.clean.datatest.AlertData;
import com.clean.datatest.FolderData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.addfolder.AddFolderPage.addFolderPage;
import static com.clean.pages.users.folderproperties.FolderPropertiesPage.folderPropertiesPage;

public class FolderTest extends DriverBase {
    @Test(alwaysRun = true,description = "Test case SDTC-... : Verify can create new folder success")
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
                .fillFolderName(UserData.FOLDER_NAME.getValue())
                .fillDescription(UserData.DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());

    }
    @Test(alwaysRun = true,description = "SDTC-41715 : Create folder name containing 1 char ")
    public void AddNewFolderWithOneChar(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(FolderData.FOLDER_1_CHAR.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
    @Test(alwaysRun = true,description = "SDTC-38626 : Check Extend icon on folder tree in SESWeb")
    public void CheckExtendIconOnFolderTree(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).verify().isCheckExtendIconOnFolderTree();
    }
    @Test(alwaysRun = true,description = "SDTC-40400 : Not allow to create folder with name over 64 chars")
    public void CreateNewFolderWith64Character(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
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

    @Test(alwaysRun = true,description = "SDTC-40294 : Folder Properties - General > Back",dependsOnMethods = "AddNewFolder")
    public void SelectFolderAndGotoFolderProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
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
    @Test(alwaysRun = true,
            description = "SDTC-38627 : Folder Properties - Folder > Add Folder",
            dependsOnMethods = "AddNewFolder"
    )
    public void addNewFolderInFolderProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolderOpt()
                .fillFolderName(FolderData.FOLDER_SUB.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Test(alwaysRun = true,
    description = "SDTC-38628 : Folder Properties - Folder > Add new Group",
    dependsOnMethods = "AddNewFolder"
    )
    public void addNewGroupInFolderProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddNewGroupOpt()
                .fillGroupName(FolderData.GROUP_SUB.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
    @Test(alwaysRun = true,
    description = "SDTC-40296 : Folder Properties - Folder > Add new user",
    dependsOnMethods = "AddNewFolder"
    )
    public void addNewUserInFolderProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay();
        folderPropertiesPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddNewUserOpt()
                .fillUserID(FolderData.USER_SUB.getValue())
                .fillPassword(FolderData.PASSWORD_USER_SUB.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }

    @Test(alwaysRun = true,
    description = "SDTC-40295 : Folder Properties - Folder > Challenge Response",
    dependsOnMethods = "AddNewFolder"
    )
        public void verifyRMCEChallengeResponse() throws InterruptedException {
            WebDriver driver;
            driver = getDriver();
            driver.get(readConfigFile.urlSESWEB());
            loginPage(driver).act()
                    .loginSESWEB(readConfigFile.username(), readConfigFile.password());
            userPage(driver).act()
                    .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
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
    @Test(alwaysRun = true,
    description = "SDTC-38642 : Folder Properties - Folder > Delete folder")
    public void DeleteFolderInFolderP() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(FolderData.FOLDER_DELETE.getValue())
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
    @Test(alwaysRun = true,
    description = "SDTC-40297 : Folder Properties - Folder > View logs",
    dependsOnMethods = "AddNewFolder")
    public void VerifyViewLogPage() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
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
    @Test(alwaysRun = true,
    description = "SDTC-38630 : Folder properties - Folder Name",
    dependsOnMethods = "AddNewFolder")
    public void VerifyTheFolderNameAfterCreatedSuccess() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay()
                .isCheckFolderNameInProperties(UserData.FOLDER_NAME.getValue());

    }
    @Test(alwaysRun = true,
    description = "SDTC-38631 : Folder properties - Description"
    )
    public void VerifyTheDescriptionAfterCreatedSuccess() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree(UserData.FOLDER_NAME.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).verify()
                .isCheckFolderPropertiesBreadcrumbDisplay()
                .isCheckDescription(UserData.DESCRIPTION.getValue());

    }
    @Test(alwaysRun = true,
    description = "SDTC-40443 : Folder properties - Folder Name - Rename")
    public void VerifyRenameFolder() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddFolder();
        addFolderPage(driver).act()
                .fillFolderName(FolderData.FOLDER_NEW.getValue())
                .fillDescription(FolderData.FOLDER_DESCRIPTION.getValue())
                .clickOnSaveBtn();
        addFolderPage(driver).verify().VerifyCreateFolderSuccess(AlertData.ALERT_SUCCESS.getValue());
        userPage(driver).act()
                .selectFolderOnFolderTree(FolderData.FOLDER_NEW.getValue())
                .hoverOnFolderMenu()
                .clickOnFolderPropertiesOpt();
        folderPropertiesPage(driver).act()
                .fillFolderName(FolderData.FOLDER_RENAME.getValue())
                .clickOnSaveBtn();
        folderPropertiesPage(driver).verify()
                .isCheckAlertSuccessDisplay();
    }


}
