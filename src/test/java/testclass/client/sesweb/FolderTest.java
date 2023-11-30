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
    @Test(alwaysRun = true,description = "SDTC-40294 : Folder Properties - General > Back")
    public void SelectFolderAndGotoFolderProperties() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectFolderOnFolderTree("k")
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

}
