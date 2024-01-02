package com.clean.pages.users.challengeresponsepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChallengeResponseElements {
    @FindBy(id = "breadcrumb_User_ChallengeResponse_4")
    WebElement challengeResponseBreadcrumb;
    @FindBy(id = "txtSecureDocChallenge")
    WebElement challengeTxt;
    @FindBy(css ="#submit_button")
    WebElement getResponseBtn;
    @FindBy(css =".alert.success")
    WebElement successAlert;

    @FindBy(css =" div.g9.Response")
    WebElement responseString;
    private ChallengeResponseElements(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    static ChallengeResponseElements getEle(WebDriver driver) {
        return new ChallengeResponseElements(driver);
    }
}
