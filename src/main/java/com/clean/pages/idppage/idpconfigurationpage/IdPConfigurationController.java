package com.clean.pages.idppage.idpconfigurationpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.idppage.idpconfigurationpage.IdPConfigurationElement.idPConfigurationElement;
import static com.clean.ults.ElementController.click;

public class IdPConfigurationController {
    private WebDriver driver;

    public IdPConfigurationController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the Configuration Menu")
    public IdPConfigurationController clickOnConfiguration(){
        click(driver,idPConfigurationElement(driver).configurationMenu);
        return this;
    }
    @Step("Click on the SAML SP tab")
    public IdPConfigurationController clickOnSAML(){
        click(driver,idPConfigurationElement(driver).samlSPTab);
        return this;
    }
    @Step("Click on the OIDC tab")
    public IdPConfigurationController clickOnOIDC(){
        click(driver,idPConfigurationElement(driver).oidcTab);
        return this;
    }
    @Step("Click on the RADIUS tab")
    public IdPConfigurationController clickOnRADIUS(){
        click(driver,idPConfigurationElement(driver).radiusTab);
        return this;
    }
}
