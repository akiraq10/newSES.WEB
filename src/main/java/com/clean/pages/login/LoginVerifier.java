package com.clean.pages.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.login.LoginElement.getLoginElement;
import static com.clean.ults.ElementController.verify;


public class LoginVerifier {
    private WebDriver driver ;


    public LoginVerifier(WebDriver driver){
        this.driver=driver;

    }
    @Step("Verify login to SES.WEB success. The SES.WED Dashboard page is displayed ")
    public LoginVerifier veirfyLoginSuccessfully() {

//        waitElement(driver,getLoginElement(driver).logoBtn);
//       assertTrue(getLoginElement(driver).logoBtn.isDisplayed(),"Not Found");
        verify(driver,getLoginElement(driver).logoWMGBtn);
        return this;
    }
    @Step("Verify fail to login to SES.WEB with invalid password. The Error is displayed")
    public LoginVerifier verifyLoginUnsuccessfully(){
//        waitElement(driver,getLoginElement(driver).unsuccessfulError);
//        assertTrue(getLoginElement(driver).unsuccessfulError.isDisplayed(),"Not Found");
        verify(driver,getLoginElement(driver).unsuccessfulError);
        return this;
    }
    @Step("Verify fail to login to SES.WEB with invalid password. The Error is displayed")
    public LoginVerifier isLoginWithoutUserNameFail(){
        verify(driver,getLoginElement(driver).useNameErr);
        return this;
    }


}
