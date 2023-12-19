package testclass.client.sesweb;

import com.clean.dataprovider.DataProvider;
import com.clean.datatest.ProfilesData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.profiles.ProfilePage.profilePage;
import static com.clean.pages.profiles.addprofile.AddProfilePage.addProfilePage;

public class ProfileTest extends DriverBase {
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify add new OSA profile success")
    public void AddNewOSAProfile(){
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
               .fillProfileName(ProfilesData.OSA_PROFILE_NAME.getValue())
               .fillProfileComment(ProfilesData.DESCRIPTION.getValue())
               .selectTargetPlatform(ProfilesData.TARGET_PLATFORM_ENDPOINT.getValue())
               .selectProfileType(ProfilesData.OSA_PROFILE_TYPE.getValue())
               .clickOnSubmitBtn();
       addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
       addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }
    @Test(description = "Test case SDTC....: Verify add new profile {profileName} success",dataProvider="readProfileData",dataProviderClass = DataProvider.class )
    public void AddNeWProfile(String profileName,String comment,String targetPlatform,String profileType){
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
               .fillProfileName(profileName)
               .fillProfileComment(comment)
               .selectTargetPlatform(targetPlatform)
               .selectProfileType(profileType)
               .clickOnSubmitBtn();
       addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
       addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }
}
