package testclass.client.sesweb.grouptest;

import com.clean.datatest.AlertData;
import com.clean.datatest.GroupData;
import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.challengeresponsepage.ChallengeResponsePage.challengeResponsePage;
import static com.clean.pages.users.checkpbconnexpage.CheckPBConnexPage.checkPBConnexPage;
import static com.clean.pages.users.grouppage.GroupPage.groupPage;

public class ActionFromUserAdvancedMenu extends DriverBase {


    @Feature("Test Suite : Group -> Action from User Advanced menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40307 : Group > User Advanced > Challenge Response",
            dependsOnMethods = {"AssignUserToGroup","ChangeTheGroupName"},
            groups = {"regression"})
    public void verifyTheChallengeResponsePage(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverMouseToUserAdvancedMenu()
                .clickOnTheChallengeResponseOpt();
        challengeResponsePage(driver).verify()
                .isCheckChallengeResponsePageDisplay();
        challengeResponsePage(driver).act()
                .fillTheChallengeString(GroupData.CHALLENGE_STRING.getValue())
                .clickOnGetResponseBtn();
        challengeResponsePage(driver).verify()
                .isCheckResponseStringDisplay()
                .isCheckAlertSuccessDisplay();
    }


    @Feature("Test Suite : Group -> Action from User Advanced menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40308 : Group > User Advanced > Check PBConnex",
            dependsOnMethods = {"AssignUserToGroup","ChangeTheGroupName"},
            groups = {"regression"})
    public void verifyCheckPBConnexPage(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverMouseToUserAdvancedMenu()
                .clickOnTheCheckPBConnexOpt();
        checkPBConnexPage(driver).verify()
                .isCheckPBConnexPageDisplay();

    }

    @Feature("Test Suite : Group -> Action from User Advanced menu")
    @Parameters({"browser","uri"})
    @Test(description = "SDTC-40309 : Group > User Advanced > Reset failed preboot logins",
            dependsOnMethods = {"AssignUserToGroup","ChangeTheGroupName"},
            groups = {"regression"})
    public void verifyResetFailedPrebootLogins(String browser,String uri) throws MalformedURLException, InterruptedException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(driver).act()
                .selectGroupOnFolderTree(browser+"_"+ GroupData.GROUP_NAME.getValue());
        groupPage(driver).act()
                .selectUserInGroup(browser+"_"+ UserData.REGULAR_USERNAME.getValue())
                .hoverMouseToUserAdvancedMenu()
                .clickOnTheResetFailedPrebootLoginOpt()
                .clickOnYesBtnOnConfirmationDialog();
        groupPage(driver).verify()
                .isCheckAlertSuccessDisplayed(AlertData.ALERT_SUCCESS.getValue());
    }
}
