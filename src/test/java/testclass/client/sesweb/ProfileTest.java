package testclass.client.sesweb;


import com.clean.datatest.ProfilesData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.profiles.ProfilePage.profilePage;
import static com.clean.pages.profiles.addprofile.AddProfilePage.addProfilePage;

public class ProfileTest extends DriverBase {
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify add new OSA profile success",
            groups = {"basic","regression"})
    public void AddNewOSAProfile(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        profilePage(driver).act()
                .clickOnProfile()
                .hoverOnProfileMenu()
                .clickOnAddProfile();
       profilePage(driver).verify().isAddProfilePageDisplay();
       addProfilePage(driver).act()
               .fillProfileName(browser+"_"+ProfilesData.OSA_PROFILE_NAME.getValue())
               .fillProfileComment(ProfilesData.DESCRIPTION.getValue())
               .selectTargetPlatform(ProfilesData.TARGET_PLATFORM_ENDPOINT.getValue())
               .selectProfileType(ProfilesData.OSA_PROFILE_TYPE.getValue())
               .clickOnSubmitBtn();
       addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
       addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }

//    @Parameters({"browser","uri"})
//    @Test(description = "Test case SDTC....: Verify add new profile {profileName} success",
//            dataProvider="readProfileData",
//            dataProviderClass = DataProvider.class,
//            groups = {"basic","regression"})
//    public void AddNeWProfile(String profileName,String comment,String targetPlatform,String profileType){
//        WebDriver driver;
//        driver = getDriver(browser);
//        driver.get(uri);
//        loginPage(driver).act()
//                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
//        profilePage(driver).act()
//                .clickOnProfile()
//                .hoverOnProfileMenu()
//                .clickOnAddProfile();
//       profilePage(driver).verify().isAddProfilePageDisplay();
//       addProfilePage(driver).act()
//               .fillProfileName(profileName)
//               .fillProfileComment(comment)
//               .selectTargetPlatform(targetPlatform)
//               .selectProfileType(profileType)
//               .clickOnSubmitBtn();
//       addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
//       addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
//    }

@Parameters({"browser","uri"})
@Test(alwaysRun = true,
        description = "Test case SDTC....: Verify add new Windows-Endpoint profile success",
        groups = {"basic","regression"})
    public void AddNewWindowsEndpointProfile(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        profilePage(driver).act()
                .clickOnProfile()
                .hoverOnProfileMenu()
                .clickOnAddProfile();
        profilePage(driver).verify().isAddProfilePageDisplay();
        addProfilePage(driver).act()
                .fillProfileName(browser+"_"+ProfilesData.ENDPOINT_PROFILE_NAME.getValue())
                .fillProfileComment(ProfilesData.DESCRIPTION.getValue())
                .selectTargetPlatform(ProfilesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectProfileType(ProfilesData.ENDPOINT_PROFILE_TYPE.getValue())
                .clickOnSubmitBtn();
        addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
        addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify add new MacOS profile success",
            groups = {"basic","regression"})
    public void AddNeWMacOSProfile(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        profilePage(driver).act()
                .clickOnProfile()
                .hoverOnProfileMenu()
                .clickOnAddProfile();
        profilePage(driver).verify().isAddProfilePageDisplay();
        addProfilePage(driver).act()
                .fillProfileName(browser+"_"+ProfilesData.MACOS_PROFILE_NAME.getValue())
                .fillProfileComment(ProfilesData.DESCRIPTION.getValue())
                .selectTargetPlatform(ProfilesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectProfileType(ProfilesData.MACOS_PROFILE_TYPE.getValue())
                .clickOnSubmitBtn();
        addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
        addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }
    @Parameters({"browser","uri"})
    @Test(alwaysRun = true,
            description = "Test case SDTC....: Verify add new Linux-Endpoint profile success",
            groups = {"basic","regression"})
    public void AddNeWLinuxProfile(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        profilePage(driver).act()
                .clickOnProfile()
                .hoverOnProfileMenu()
                .clickOnAddProfile();
        profilePage(driver).verify().isAddProfilePageDisplay();
        addProfilePage(driver).act()
                .fillProfileName(browser+"_"+ProfilesData.ENDPOINT_LINUX_PROFILE_NAME.getValue())
                .fillProfileComment(ProfilesData.DESCRIPTION.getValue())
                .selectTargetPlatform(ProfilesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectProfileType(ProfilesData.LINUX_PROFILE_TYPE.getValue())
                .clickOnSubmitBtn();
        addProfilePage(driver).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
        addProfilePage(driver).act().clickOnOkOnTheConfirmDialogBtn();
    }
}
