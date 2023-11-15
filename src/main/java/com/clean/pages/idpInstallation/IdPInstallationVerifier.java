package com.clean.pages.idpInstallation;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.idpInstallation.IdPInstallationElement.getElement;
import static org.testng.Assert.assertTrue;


public class IdPInstallationVerifier {
    private WebDriver driver ;


    public IdPInstallationVerifier(WebDriver driver) {
        this.driver=driver;

    }


    public IdPInstallationVerifier verifyConfigSuccess() throws InterruptedException {
        Thread.sleep(500);
        assertTrue(getElement(driver).signInBtn.isDisplayed());
        return this;
    }


}
