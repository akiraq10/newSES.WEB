package com.clean.pages.idppage.idpconfigurationpage;


import org.openqa.selenium.WebDriver;

import static com.clean.pages.idppage.idpconfigurationpage.IdPConfigurationElement.idPConfigurationElement;
import static com.clean.ults.ElementController.click;

public class IdPConfigurationController {
    private WebDriver driver;

    public IdPConfigurationController(WebDriver driver) {
        this.driver = driver;
    }

    public IdPConfigurationController clickOnConfiguration(){
        click(driver,idPConfigurationElement(driver).configurationMenu);
        return this;
    }

    public IdPConfigurationController clickOnSAML(){
        click(driver,idPConfigurationElement(driver).samlSPTab);
        return this;
    }

    public IdPConfigurationController clickOnOIDC(){
        click(driver,idPConfigurationElement(driver).oidcTab);
        return this;
    }

    public IdPConfigurationController clickOnRADIUS(){
        click(driver,idPConfigurationElement(driver).radiusTab);
        return this;
    }
}
