package com.clean.pages.idppage.idphomepage;

import org.openqa.selenium.WebDriver;

public class IdPHomePage {
    private IdPHomePage(IdPHomePageController idPHomePageController, IdPHomePageVerifier idPHomePageVerifier) {
        this.idPHomePageController = idPHomePageController;
        this.idPHomePageVerifier = idPHomePageVerifier;
    }
    public static IdPHomePage idPHomePage(WebDriver driver)
    {
        return new IdPHomePage(new IdPHomePageController(driver),new IdPHomePageVerifier(driver));
    }

    public IdPHomePageController act() {
        return idPHomePageController;
    }

    public IdPHomePageVerifier verify() {
        return idPHomePageVerifier;
    }

    IdPHomePageController idPHomePageController;
    IdPHomePageVerifier idPHomePageVerifier;

}
