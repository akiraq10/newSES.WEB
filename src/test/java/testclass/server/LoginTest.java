package testclass.server;

import com.clean.driver.DriverBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;

public class LoginTest extends DriverBase {

//    WebDriver driver;


    @Feature("Login Test")
    @Description(" Verify login SES.WEB with valid pwd success")
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = " Test case SDTC....: Login SES.WEB with valid PWD",
    groups = {"basic","regression"})
    public void loginValidCredentials(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver=getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.password())
                .clickONLoginBtn();
        loginPage(driver).verify().veirfyLoginSuccessfully();



    }
    @Feature("Login Test")
    @Description("Verify unable to login SES.WEB with invalid pwd ")
    @Parameters({"browser","uri"})
    @Test(description = "Test case SDTC....: Login SES.WEB with invalid PWD",
            groups = {"basic","regression"})
    public void loginInvalidCredentials(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver=getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.invalidPwd())
                .clickONLoginBtn();
        loginPage(driver).verify().verifyLoginUnsuccessfully();


    }


}
