package testclass.client.sesweb.grouptest;

import com.clean.datatest.AlertData;
import com.clean.datatest.GroupData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.addgroup.AddGroupPage.addGroupPage;
import static com.clean.pages.users.grouppage.GroupPage.groupPage;
import static com.clean.pages.users.groupproperties.GroupPropertiesPage.groupPropertiesPage;
import static com.clean.pages.users.movetofolder.MoveToFolderPage.moveToFolderPage;

public class ActionFromGroupMenu extends DriverBase {
    String browser="chrome";
    String uri="https://messo.asia";
    @Feature("Test Suite : Group -> Action from Group menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-44663 : Group > Group > Group Properties",
            dependsOnMethods = {"CreateNewGroup"},
            groups = {"regression"})
    public void verifyTheGroupProperties(String browser, String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());

        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupPropertiesOpt();

        groupPropertiesPage(driver).verify()
                .isCheckGeneralPageDisplay();

    }

    @Feature("Test Suite : Group -> Action from Group menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-26449 : Group > Group > Move to folder",
            dependsOnMethods = {"AssignUserToGroup","verifyTheGroupProperties"},
            groups = {"regression"})
    public void verifyMoveGroupToAnotherFolder(String browser,String uri) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());

        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnGroupMoveToFolder();

        moveToFolderPage(driver).verify()
                .isCheckMoveGroupToFolderPageDisplay();
        moveToFolderPage(driver).act()
                .selectFolder(browser+"_"+ UserData.FOLDER_NAME.getValue())
                .clickOnMoveBtn();
        groupPage(driver).verify()
                .isCheckAlertSuccessDisplayed(AlertData.ALERT_COMMAND_SUCCESS.getValue());

    }
    @Feature("Test Suite : Group -> Action from Group menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40310 : Group > Group > Delete group",
            groups = {"regression"})
    public void verifyDeleteGroup(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddGroup();

        addGroupPage(driver).act()
                .fillGroupName(browser+"_"+GroupData.GROUP_NAME_TEST_DELETE.getValue())
                .clickOnSaveButton();

        addGroupPage(driver).verify().isCheckAddGroupSuccess(AlertData.ALERT_SUCCESS.getValue());
        userPage(driver).act()
                .selectGroupOnFolderTreeNotClickExpandIcon(browser+"_"+GroupData.GROUP_NAME_TEST_DELETE.getValue());
        groupPage(driver).act()
                .hoverToGroupMenu()
                .clickOnDeleteGroupOpt()
                .clickOnYesBtnOnConfirmationDialog();

        userPage(driver).verify()
                .isCheckAlertSuccessDisplay();

    }
}
