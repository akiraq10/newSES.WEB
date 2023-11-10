package testclass.client.sesweb;

import com.clean.datatest.UserData;
import com.clean.driver.DriverBase;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;

import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.addgroup.AddGroupPage.addGroupPage;

public class GroupTest extends DriverBase {
    @Description("Test case ID:")
    @Test(description = " Test Case ID...: Check create new group with valid data success")
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
                .fillGroupName(UserData.GROUP_NAME.getValue())
                .clickOnSaveButton();

        addGroupPage(driver).verify().isCheckAddGroupSuccess(readConfigFile.alertSuccess());

    }

}
