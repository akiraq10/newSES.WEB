package com.clean.pages.configuration.administratormanagement.editadiminuser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

import static com.clean.pages.configuration.administratormanagement.editadiminuser.ModifyAdminUserElement.modifyAdminUserElement;
import static com.clean.ults.ElementController.verify;

public class ModifyAdminUserVerifier {
    private WebDriver driver;

    public ModifyAdminUserVerifier(WebDriver driver) {
        this.driver = driver;
    }
    public ModifyAdminUserVerifier isAdminPropertiesPageDisplay(){
        verify(driver,modifyAdminUserElement(driver).propertiesAdminBreadcrumb);
        return this;
    }
}
