package testclass.client.idp;

import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.idppage.idphomepage.IdPHomePage.idPHomePage;
import static com.clean.pages.idppage.idploginpage.LoginIdpPage.loginIdpPage;

public class IdPLoginTest extends DriverBase {
    @Test(dependsOnMethods = "ModifyUserAddEmail")
    public void loginIdPViaUserRight(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.idpSESWEB());
        loginIdpPage(driver).act()
                .clickOnSignInBtn();
        idPHomePage(driver).verify()
                .isHomePageDisplayed();
//                .isOnlineUserNotDisplayed();
    }
    @Test(dependsOnMethods = {"ModifyUserAddEmail","assignAdminRoleToAdminUser"})
    public void loginIdPViaAdminRight(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.idpSESWEB());
        loginIdpPage(driver).act()
                .clickOnSignInBtn();
        idPHomePage(driver).verify()
                .isHomePageDisplayed();
//                .isOnlineUserDisplayed();
    }
}
