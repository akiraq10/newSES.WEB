package testclass.client.sesweb;

import com.clean.datatest.PackagesData;
import com.clean.datatest.ProfilesData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.clean.pages.installationpkg.PkgPage.pkgPage;
import static com.clean.pages.installationpkg.addnewpacakge.AddPkgPage.addPkgPage;
import static com.clean.pages.login.LoginPage.loginPage;

public class PackageTest extends DriverBase {

    @Parameters({"browser","uri"})
    @Test(dependsOnMethods ={"AddNewOSAProfile"},
            description = "Test case SDTC....: Verify create new OSA package success",
            groups = {"basic","regression"})
    public void AddNewOSAPackage(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
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
//    @Parameters({"browser","uri"})
//    @Test(dependsOnMethods = "AddNeWProfile",
//            description = "Test case SDTC....: Verify create new package success",
//            dataProvider="readPackageData",
//            dataProviderClass = DataProvider.class,
//            groups = {"basic","regression"})
//    public void AddNewPackage(String targetPlatform,String packageType,String profileName,String packageName,String description){
//        WebDriver driver;
//        driver = getDriver(browser);
//        driver.get(uri);
//        loginPage(driver).act()
//                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
//        pkgPage(driver).act().clickOnInstallationPage();
//        pkgPage(driver).verify().isInstallationPageDisplay();
//        pkgPage(driver).act().hoverOnPackageMenu()
//                .clickOnAddPackage();
//        addPkgPage(driver).verify().isAddPackagePageDisplay();
//        addPkgPage(driver).act()
//                .selectTargetPlatform(targetPlatform)
//                .selectPackageType(packageType)
//                .selectProfileName(profileName)
//                .fillDescription(description)
//                .clickOnSubmitBtn();
//        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
//        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();
//
//    }
@Parameters({"browser","uri"})
@Test(dependsOnMethods ={"AddNewWindowsEndpointProfile"},
        description = "Test case SDTC....: Verify create new Windows Endpoint package success",
        groups = {"basic","regression"})
    public void AddNewWindowsEndpointPackage(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        pkgPage(driver).act().clickOnInstallationPage();
        pkgPage(driver).verify().isInstallationPageDisplay();
        pkgPage(driver).act().hoverOnPackageMenu()
                .clickOnAddPackage();
        addPkgPage(driver).verify().isAddPackagePageDisplay();
        addPkgPage(driver).act()
                .selectTargetPlatform(PackagesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectPackageType(PackagesData.ENDPOINT_PACKAGE_TYPE.getValue())
                .selectProfileName(ProfilesData.ENDPOINT_PROFILE_NAME.getValue())
                .fillDescription(PackagesData.DESCRIPTION.getValue())
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }

    @Parameters({"browser","uri"})
    @Test(dependsOnMethods ={"AddNeWMacOSProfile"},
            description = "Test case SDTC....: Verify create new MacOS package success",
            groups = {"basic","regression"})
    public void AddNewMacOSPackage(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        pkgPage(driver).act().clickOnInstallationPage();
        pkgPage(driver).verify().isInstallationPageDisplay();
        pkgPage(driver).act().hoverOnPackageMenu()
                .clickOnAddPackage();
        addPkgPage(driver).verify().isAddPackagePageDisplay();
        addPkgPage(driver).act()
                .selectTargetPlatform(PackagesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectPackageType(PackagesData.MACOS_PACKAGE_TYPE.getValue())
                .selectProfileName(ProfilesData.MACOS_PROFILE_NAME.getValue())
                .fillDescription(PackagesData.DESCRIPTION.getValue())
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }
    @Parameters({"browser","uri"})
    @Test(dependsOnMethods ={"AddNeWLinuxProfile"},
            description = "Test case SDTC....: Verify create new Linux Endpoint package success",
            groups = {"basic","regression"})
    public void AddNewLinuxEndpointPackage(String browser,String uri) throws MalformedURLException {
        WebDriver driver;
        driver = getDriver(browser);
        driver.get(uri);
        loginPage(driver).act()
                .loginSESWEB(readConfigFile.username(), readConfigFile.password());
        pkgPage(driver).act().clickOnInstallationPage();
        pkgPage(driver).verify().isInstallationPageDisplay();
        pkgPage(driver).act().hoverOnPackageMenu()
                .clickOnAddPackage();
        addPkgPage(driver).verify().isAddPackagePageDisplay();
        addPkgPage(driver).act()
                .selectTargetPlatform(PackagesData.TARGET_PLATFORM_ENDPOINT.getValue())
                .selectPackageType(PackagesData.LINUX_PACKAGE_TYPE.getValue())
                .selectProfileName(ProfilesData.ENDPOINT_LINUX_PROFILE_NAME.getValue())
                .fillDescription(PackagesData.DESCRIPTION.getValue())
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }

}
