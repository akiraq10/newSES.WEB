package testclass;

import com.clean.dataprovider.ReadDataFromJSon;
import com.clean.dataprovider.getdata.CreateUserData;
import com.clean.datatest.AlertData;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.users.UserPage.userPage;
import static com.clean.pages.users.adduser.AddUserPage.addUserPage;

public class testNG2 extends BaseTest{
    @Test(dataProvider = "userDataSet",dataProviderClass = ReadDataFromJSon.class)
    public void addNewUser(CreateUserData createUserData) throws MalformedURLException {
        loginPage(getDriver()).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        userPage(getDriver()).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();
        addUserPage(getDriver()).act()
                .fillUserID(browser+"_"+ createUserData.getUserID())
                .fillPWD(createUserData.getUserPWD())
                .fillDescription(browser+"_"+createUserData.getDescription())
                .selectUserType(createUserData.getUserType())
                .clickOnSaveBtn();
        addUserPage(getDriver()).verify().verifyCreateUserSuccess(AlertData.ALERT_SUCCESS.getValue());
    }
}
