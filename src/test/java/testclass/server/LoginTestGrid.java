package testclass.server;

import com.clean.driver.DriverBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;

public class LoginTestGrid extends DriverBase {

//    WebDriver driver;
    WebDriver driver;


    @Feature("Login Test")
    @Description(" Verify login SES.WEB with valid pwd success")
    @Parameters({"browser"})
    @Test(description = " Test case SDTC....: Login SES.WEB with valid PWD")
    public void loginValidCredentials(String browser) throws MalformedURLException {
//        WebDriver driver;
        driver=getDriver(browser);
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.password())
                .clickONLoginBtn();
        loginPage(driver).verify().veirfyLoginSuccessfully();



    }
    @Feature("Login Test")
    @Description("Verify unable to login SES.WEB with invalid pwd ")
    @Parameters({"browser"})
    @Test(description = "Test case SDTC....: Login SES.WEB with invalid PWD")
    public void loginInvalidCredentials(String browser) throws MalformedURLException {
//        WebDriver driver;
        driver=getDriver(browser);
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.invalidPwd())
                .clickONLoginBtn();
        loginPage(driver).verify().verifyLoginUnsuccessfully();


    }
    @Parameters({"browser"})
    @Test
    public void testParameter(String browser){
        System.out.println(browser);

    }

}
