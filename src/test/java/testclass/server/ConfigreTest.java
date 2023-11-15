package testclass.server;

import com.clean.driver.DriverBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

import static com.clean.pages.idpInstallation.IdPInstallationPage.idPInstallationPage;
import static com.clean.pages.webInstallation.WebInstallationPage.webInstallationPage;


public class ConfigreTest extends DriverBase {
    String urlLocalhost = readConfigFile.Scheme() + readConfigFile.domain() + ":";


    @Test(description = "Test case SDTC....: Verify can config SES.WEB success")
    public void config_SESWEB() throws InterruptedException {
        WebDriver driver;
        driver = getDriver();
        driver.get(urlLocalhost + readConfigFile.SESWEBPort() + readConfigFile.Subdirectory());
        webInstallationPage(driver).act().fillKF(readConfigFile.KFPath())
                .fillKFPwd(readConfigFile.KFPwd())
                .fillServerName(readConfigFile.ServeName())
                .fillDatabase(readConfigFile.DatabaseName())
                .fillSqlUserName(readConfigFile.SQLUserName())
                .fillSQLPWD(readConfigFile.SQLPwd())
                .fillServerPublickUrL(readConfigFile.ServerPublicUrL())
                .enableDebugLog()
                .clickOnConfigureBtn();
        webInstallationPage(driver).verify().verifyAfterConfigSuccess();


    }


    @Test(description = "Test case SDTC....: Verify can config IdP portal success")
    public void config_IdP() throws InterruptedException, AWTException {
        WebDriver driver;
        driver = getDriver();
        driver.get(urlLocalhost + readConfigFile.IdPPort() + readConfigFile.Subdirectory());
        idPInstallationPage(driver).act()
                .fillKF(readConfigFile.KFPath())
                .fillKFPWD(readConfigFile.KFPwd())
                .fillServerName(readConfigFile.ServeName())
                .fillDatabase(readConfigFile.DatabaseName())
                .fillSQLUserName(readConfigFile.SQLUserName())
                .fillSQLPWD(readConfigFile.SQLPwd())
                .fillIdPServerUrl(readConfigFile.ServerUrl())
                .fillSESWebUrl(readConfigFile.SESWEBUrl())
                .enableDebug()
                .clickSaveBtn();
        idPInstallationPage(driver).verify().verifyConfigSuccess();


    }
}
