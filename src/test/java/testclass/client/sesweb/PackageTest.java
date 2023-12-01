package testclass.client.sesweb;

import com.clean.dataprovider.DataProvider;
import com.clean.datatest.PackagesData;
import com.clean.datatest.ProfilesData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.installationpkg.PkgPage.pkgPage;
import static com.clean.pages.installationpkg.addnewpacakge.AddPkgPage.addPkgPage;
import static com.clean.pages.login.LoginPage.loginPage;

public class PackageTest extends DriverBase {

    @Test(dependsOnMethods ={"AddNewOSAProfile"},
            description = "Test case SDTC....: Verify create new OSA package success" )
    public void AddNewOSAPackage(){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        pkgPage(driver).act().clickOnInstallationPage();
        pkgPage(driver).verify().isInstallationPageDisplay();
        pkgPage(driver).act().hoverOnPackageMenu()
                .clickOnAddPackage();
        addPkgPage(driver).verify().isAddPackagePageDisplay();
        addPkgPage(driver).act()
                .selectTargetPlatform(PackagesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectPackageType(PackagesData.OSA_PACKAGE_TYPE.getValue())
                .selectProfileName(ProfilesData.OSA_PROFILE_NAME.getValue())
                .fillDescription(PackagesData.DESCRIPTION.getValue())
                .clickOnRecoveryAccessSettingPage()
                .fillInitialPWD(PackagesData.OSA_INITIAL_PASSWORD.getValue())
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }
    @Test(dependsOnMethods = "AddNeWProfile",
            description = "Test case SDTC....: Verify create new package success",
            dataProvider="readPackageData",
            dataProviderClass = DataProvider.class )
    public void AddNewPackage(String targetPlatform,String packageType,String profileName,String packageName,String description){
        WebDriver driver;
        driver = getDriver();
        driver.get(readConfigFile.urlSESWEB());
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        pkgPage(driver).act().clickOnInstallationPage();
        pkgPage(driver).verify().isInstallationPageDisplay();
        pkgPage(driver).act().hoverOnPackageMenu()
                .clickOnAddPackage();
        addPkgPage(driver).verify().isAddPackagePageDisplay();
        addPkgPage(driver).act()
                .selectTargetPlatform(targetPlatform)
                .selectPackageType(packageType)
                .selectProfileName(profileName)
                .fillDescription(description)
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }

}
