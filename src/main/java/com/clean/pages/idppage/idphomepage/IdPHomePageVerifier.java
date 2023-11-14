package com.clean.pages.idppage.idphomepage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.idppage.idphomepage.IdPHomePageElement.idPHomePageElement;
import static com.clean.ults.ElementController.verify;
import static com.clean.ults.ElementController.verifyElementNotDisplay;

public class IdPHomePageVerifier {
    private WebDriver driver;

    public IdPHomePageVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify user login to IdP portal success")
    public IdPHomePageVerifier isHomePageDisplayed(){
        verify(driver,idPHomePageElement(driver).homeMenu);
        return this;
    }
    @Step("Verify user login to IdP portal via Admin right  success")
    public IdPHomePageVerifier isOnlineUserDisplayed(){
        verify(driver,idPHomePageElement(driver).onlineUserText);
        return this;
    }
    @Step("Verify user login to IdP portal via User right  success")
    public IdPHomePageVerifier isOnlineUserNotDisplayed(){
        verifyElementNotDisplay(driver,idPHomePageElement(driver).onlineUserText);
        return this;
    }
}
