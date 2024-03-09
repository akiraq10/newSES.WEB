package testclass.client.sesweb;

import com.clean.dataprovider.ReadDataFromJSon;
import com.clean.dataprovider.getdata.CreateUserData;
import com.clean.datatest.AlertData;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import testclass.BaseTest;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;
import static com.clean.pages.users.edituser.EditUserPage.editUserPage;

public class UsersTest extends BaseTest {

    @Description(" Verify Create a new user with Regular/Auto/Temp user type on SES.WEB success ")
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify create new user success",
            groups = {"basic","regression"},
            dataProvider = "userDataSet",dataProviderClass = ReadDataFromJSon.class)
    public void AddNewUser(CreateUserData userData) throws MalformedURLException {
        loginPage(getDriver()).act()
                .loginSESWEB(adminSESWEBUser, pwdSESWEBUser);
        userPage(getDriver()).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(getDriver()).act()
                .fillUserID(browser+"_"+userData.getUserID())
                .fillPWD(userData.getUserPWD())
                .fillDescription(browser+"_"+userData.getUserType());
        if (!userData.isFinalPwd()){
            addUserPage(getDriver()).act()
                    .selectUserType(userData.getUserType());
        }else {
            addUserPage(getDriver()).act().unCheckFinalPassword();
        }
        addUserPage(getDriver()).act().clickOnSaveBtn();


        addUserPage(getDriver()).verify()
                .verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
    }



    @Test(
            description = "Test case SDTC....:Verify admin can add email for an existing user",
            groups = {"basic","regression"},
            dependsOnMethods = "AddNewUser",
            dataProvider = "userDataSet",dataProviderClass = ReadDataFromJSon.class)
    public void ModifyUserAddEmail(CreateUserData userData) throws InterruptedException, MalformedURLException {
        if (userData.getEmail()!=null) {
            loginPage(getDriver()).act()
                    .loginSESWEB(adminSESWEBUser, pwdSESWEBUser);
            userPage(getDriver()).act()
                    .selectExistingUser(browser+"_"+userData.getUserID())
                    .hoverOnUserMenu()
                    .clickOnViewPropertiesOpt();
            editUserPage(getDriver()).act()
                    .fillEmail(userData.getEmail())
                    .clickOnSaveBtn();
            editUserPage(getDriver()).verify().isAlertSuccessDisplay();
        }
    }

}
