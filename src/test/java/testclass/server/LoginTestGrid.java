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
    @Parameters({"browser","uri"})
    @Description(" Verify login SES.WEB with valid pwd success")
    @Test(description = " Test case SDTC....: Login SES.WEB with valid PWD")
    public void loginValidCredentials(String browser,String Uri) throws MalformedURLException {
//        WebDriver driver;
        driver=getDriver(browser);
        driver.get(Uri);
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.password())
                .clickONLoginBtn();
        loginPage(driver).verify().veirfyLoginSuccessfully();



    }
    @Feature("Login Test")
    @Parameters({"browser","uri"})
    @Description("Verify unable to login SES.WEB with invalid pwd ")
    @Test(alwaysRun = true,description = "Test case SDTC....: Login SES.WEB with invalid PWD")
    public void loginInvalidCredentials(String browser,String Uri) throws MalformedURLException {
//        WebDriver driver;
        driver=getDriver(browser);
        driver.get(Uri);
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
