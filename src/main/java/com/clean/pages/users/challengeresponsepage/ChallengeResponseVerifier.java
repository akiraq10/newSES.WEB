package com.clean.pages.users.challengeresponsepage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.challengeresponsepage.ChallengeResponseElements.getEle;
import static com.clean.ults.ElementController.verify;

public class ChallengeResponseVerifier {
    WebDriver driver;

    ChallengeResponseVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify The Challenge Response page is displayed")
    public ChallengeResponseVerifier isCheckChallengeResponsePageDisplay() {
        verify(driver,getEle(driver).challengeResponseBreadcrumb);
        return this;
    }
    @Step("Verify the Response String is displayed")
    public ChallengeResponseVerifier isCheckResponseStringDisplay() {
        verify(driver,getEle(driver).responseString);
        return this;
    }
    @Step("Verify the Alert Success is displayed")
    public ChallengeResponseVerifier isCheckAlertSuccessDisplay() {
        verify(driver,getEle(driver).responseString);
        return this;
    }
}
