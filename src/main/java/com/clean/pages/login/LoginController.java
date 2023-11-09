package com.clean.pages.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.clean.pages.login.LoginElement.getLoginElement;
import static com.clean.pages.login.LoginPage.loginPage;
import static com.clean.ults.ElementController.click;
import static com.clean.ults.ElementController.fill;


public class LoginController {
    private WebDriver driver ;
    public LoginController(WebDriver driver){
        this.driver=driver;

    }

    @Step("Input the username as: {username}")
    public LoginController fillUserName(String username) {
        fill(driver,getLoginElement(driver).userName,username);
        return this;
    }

    @Step("Input the password as: {password}")
    public LoginController fillPassword(String password) {
        fill(driver,getLoginElement(driver).password,password);
        return this;
    }

    @Step("Click on the Login button")
    public LoginController clickONLoginBtn() {
        click(driver,getLoginElement(driver).loginBtn);
        return this;

    }
    public void loginSESWEB(String userName,String password){
        fillUserName(userName)
                .fillPassword(password)
                .clickONLoginBtn();
        loginPage(driver).verify().veirfyLoginSuccessfully();


    }
}
