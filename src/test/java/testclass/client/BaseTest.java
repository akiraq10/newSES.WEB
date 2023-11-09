package testclass.client;

import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import static com.clean.pages.login.LoginPage.loginPage;

public class test1 extends DriverBase {
    WebDriver driver;
    @BeforeClass()
    public void initial(){

        driver=getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .fillUserName(readConfigFile.username())
                .fillPassword(readConfigFile.password())
                .clickONLoginBtn();
        loginPage(driver).verify().veirfyLoginSuccessfully();
    }
}
