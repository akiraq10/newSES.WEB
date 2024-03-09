package testclass.client;

import com.clean.dataprovider.ReadDataFromJSon;
import com.clean.dataprovider.getdata.LoginData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import testclass.BaseTest;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;

public class LoginTest extends BaseTest {

//    WebDriver driver;


    @Feature("Login Test")
    @Description(" Verify login SES.WEB with valid pwd success")
    @Test(alwaysRun = true,
            description = " Test case SDTC....: Login SES.WEB with valid PWD",
            groups = {"basic","regression"},
            dataProvider = "loginValidData",dataProviderClass = ReadDataFromJSon.class)
    public void loginValidCredentials(LoginData loginData) throws MalformedURLException {

        loginPage(getDriver()).act()
                .fillUserName(loginData.getUserName())
                .fillPassword(loginData.getPwd())
                .clickONLoginBtn();
        loginPage(getDriver()).verify().veirfyLoginSuccessfully();



    }
    @Feature("Login Test")
    @Description("Verify unable to login SES.WEB with invalid pwd ")
    @Test(description = "Test case SDTC....: Login SES.WEB with invalid PWD",
            groups = {"basic","regression"},
            dataProvider = "loginInvalidData",dataProviderClass = ReadDataFromJSon.class)
    public void loginInvalidCredentials(LoginData loginData) throws MalformedURLException {

        loginPage(getDriver()).act()
                .fillUserName(loginData.getUserName())
                .fillPassword(loginData.getPwd())
                .clickONLoginBtn();

        if(loginData.getUserName().isEmpty()){
            loginPage(getDriver()).verify().isLoginWithoutUserNameFail();
        }else {
            loginPage(getDriver()).verify().verifyLoginUnsuccessfully();}


    }


}
