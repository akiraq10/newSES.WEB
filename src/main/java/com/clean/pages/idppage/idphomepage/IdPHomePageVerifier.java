package com.clean.pages.idppage.idphomepage;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.idppage.idphomepage.IdPHomePageElement.idPHomePageElement;
import static com.clean.ults.ElementController.verify;
import static com.clean.ults.ElementController.verifyElementNotDisplay;

public class IdPHomePageVerifier {
    private WebDriver driver;

    public IdPHomePageVerifier(WebDriver driver) {
        this.driver = driver;
    }

    public IdPHomePageVerifier isHomePageDisplayed(){
        verify(driver,idPHomePageElement(driver).homeMenu);
        return this;
    }

    public IdPHomePageVerifier isOnlineUserDisplayed(){
        verify(driver,idPHomePageElement(driver).onlineUserText);
        return this;
    }

    public IdPHomePageVerifier isOnlineUserNotDisplayed(){
        verifyElementNotDisplay(driver,idPHomePageElement(driver).onlineUserText);
        return this;
    }
}
