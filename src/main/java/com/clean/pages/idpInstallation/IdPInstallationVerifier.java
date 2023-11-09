package com.clean.pages.idpInstallation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.idpInstallation.IdPInstallationElement.getElement;
import static org.testng.Assert.assertTrue;


public class IdPInstallationVerifier {
    private WebDriver driver ;


    public IdPInstallationVerifier(WebDriver driver) {
        this.driver=driver;

    }

    @Step("Expected: IdP is configrd success")
    public IdPInstallationVerifier verifyConfigSuccess() throws InterruptedException {
        Thread.sleep(500);
        assertTrue(getElement(driver).signInBtn.isDisplayed());
        return this;
    }


}
