package testclass.client.sesweb;

import com.clean.driver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.clean.pages.installationpkg.PkgPage.pkgPage;
import static com.clean.pages.installationpkg.addnewpacakge.AddPkgPage.addPkgPage;
import static com.clean.pages.login.LoginPage.loginPage;

public class PackageTest extends DriverBase {

    @Test(dependsOnMethods ={"AddNewProFile"},description = "Test case SDTC....: Verify create new package success" )
    public void addNewPackage(){
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
                .selectProfileName("kkk1")
                .fillDescription("abc")
                .clickOnSubmitBtn();
        addPkgPage(driver).verify().isConfirmationDialogDisplay();
        addPkgPage(driver).act().clickOnOkBtnOnConfirmationDialog();

    }

}
