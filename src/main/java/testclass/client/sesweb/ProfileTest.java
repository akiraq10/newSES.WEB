package testclass.client.sesweb;


import com.clean.dataprovider.ReadDataFromJSon;
import com.clean.dataprovider.getdata.ProfileData;
import com.clean.datatest.ProfilesData;
import org.testng.annotations.Test;
import testclass.BaseTest;

import java.net.MalformedURLException;

import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.pages.profiles.ProfilePage.profilePage;
import static com.clean.pages.profiles.addprofile.AddProfilePage.addProfilePage;

public class ProfileTest extends BaseTest {


    @Test(description = "Test case SDTC....: Verify add new profile {profileName} success",
            dataProvider="ProfileData",
            dataProviderClass = ReadDataFromJSon.class,
            groups = {"basic","regression"})
    public void addNewDefaultProfile(ProfileData profileData) throws MalformedURLException {
        loginPage(getDriver()).act()
                .loginSESWEB(adminSESWEBUser, pwdSESWEBUser);
        profilePage(getDriver()).act()
                .clickOnProfile()
                .hoverOnProfileMenu()
                .clickOnAddProfile();
       profilePage(getDriver()).verify().isAddProfilePageDisplay();
       addProfilePage(getDriver()).act()
               .fillProfileName(browser+"_"+profileData.getProfileName())
               .fillProfileComment(browser+"_"+profileData.getComments())
               .selectTargetPlatform(profileData.getTargetPlatform())
               .selectProfileType(profileData.getProfileType())
               .clickOnSubmitBtn();
       addProfilePage(getDriver()).verify().isConfirmDialogDisplay(ProfilesData.PROFILE_SUCCESS_ALERT.getValue());
       addProfilePage(getDriver()).act().clickOnOkOnTheConfirmDialogBtn();

    }

}
