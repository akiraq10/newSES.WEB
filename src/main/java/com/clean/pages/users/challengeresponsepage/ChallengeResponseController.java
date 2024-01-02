package com.clean.pages.users.challengeresponsepage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.users.challengeresponsepage.ChallengeResponseElements.getEle;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;

public class ChallengeResponseController {
    WebDriver driver;

    ChallengeResponseController(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter the Challenge String as: {challenge}")
    public ChallengeResponseController fillTheChallengeString(String challenge) {
        fill(driver,getEle(driver).challengeTxt,challenge);
        return this;
    }
    @Step("Click on the Get Response button")
    public ChallengeResponseController clickOnGetResponseBtn(){
        click(driver,getEle(driver).getResponseBtn);
        return this;
    }
}
