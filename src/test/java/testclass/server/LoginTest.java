package testclass.server;

import com.clean.driver.DriverBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;

public class LoginTest extends DriverBase {

//    WebDriver driver;



    @Test(description = " Test case SDTC....: Login SES.WEB with valid PWD")
    public void loginValidCredentials(){
        WebDriver driver;
        driver=getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.password())
                .clickONLoginBtn();
        loginPage(driver).verify().veirfyLoginSuccessfully();



    }


    @Test(description = "Test case SDTC....: Login SES.WEB with invalid PWD")
    public void loginInvalidCredentials(){
        WebDriver driver;
        driver=getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.invalidPwd())
                .clickONLoginBtn();
        loginPage(driver).verify().verifyLoginUnsuccessfully();


    }


}
