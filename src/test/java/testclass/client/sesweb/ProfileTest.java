package testclass.client.sesweb;

import com.clean.datatest.ProfilesData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.profiles.ProfilePage.profilePage;
import static com.clean.pages.profiles.addprofile.AddProfilePage.addProfilePage;

public class ProfileTest extends DriverBase {
    @Test(description = "Test case SDTC....: Verify add new profile success")
    public void AddNewEndpointProfile(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        profilePage(driver).act()
                .clickOnProfile()
                .hoverOnProfileMenu()
                .clickOnAddProfile();
       profilePage(driver).verify().isAddProfilePageDisplay();
       addProfilePage(driver).act()
               .fillProfileName(ProfilesData.ENDPOINT_PROFILE_NAME.getValue())
               .fillProfileComment(ProfilesData.DESCRIPTION.getValue())
               .clickOnSubmitBtn();
       addProfilePage(driver).verify().isConfirmDialogDisplay();
       addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }
}
