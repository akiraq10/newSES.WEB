package testclass;

import com.clean.driver.DriverBase;
import com.clean.pages.login.LoginController;
import com.clean.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;

public class Test1 extends DriverBase {

//    WebDriver driver;



    @Test
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
    @Test
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
