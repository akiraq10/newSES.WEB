package com.clean.pages.users.checkpbconnexpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.checkpbconnexpage.CheckPBConnexElement.getEle;
import static com.clean.ults.ElementController.verify;

public class CheckPBConnexVerifier {
    WebDriver driver;

    CheckPBConnexVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Check PBConnex is displayed")
    public CheckPBConnexVerifier isCheckPBConnexPageDisplay() {
        verify(driver,getEle(driver).checkPBConnexBreadcrumb);
        return this;
    }
}
