package testclass.client.sesweb;

import com.clean.datatest.PackagesData;
import com.clean.datatest.ProfilesData;
import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.installationpkg.PkgPage.pkgPage;
import static com.clean.pages.installationpkg.addnewpacakge.AddPkgPage.addPkgPage;
import static com.clean.pages.login.LoginPage.loginPage;

public class PackageTest extends DriverBase {

    @Test(dependsOnMethods ={"AddNewEndpointProfile"},description = "Test case SDTC....: Verify create new package success" )
    public void AddNewEndpointPackage(){
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
                .selectProfileName(ProfilesData.ENDPOINT_PROFILE_NAME.getValue())
                .fillDescription(PackagesData.DESCRIPTION.getValue())
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay(PackagesData.PACKAGE_SUCCESS_ALERT.getValue());
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }

}
