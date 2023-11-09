package com.clean.pages.adduser;


import com.clean.datatest.UserData;
import com.clean.pages.idpInstallation.IdPInstallationController;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static com.clean.datatest.UserData.*;
import static com.clean.pages.adduser.AddUserElement.getAddUserElem;
import static com.clean.ults.ElementController.*;

public class AddUserController {
    private WebDriver driver ;

    public AddUserController(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Input the KF path as: {userID}")
    public AddUserController fillUserID(String userID ) {
        fill(driver,getAddUserElem(driver).userIDTXT,userID);
        return this;
    }
    @Step("Input the KF path as: {password}")
    public AddUserController fillPWD(String password ) {
        fill(driver,getAddUserElem(driver).passwordTXT,password);
        return this;
    }
    @Step("Input the KF path as: {firstname}")
    public AddUserController fillFirstName(String firstname ) {
        fill(driver,getAddUserElem(driver).firstNameTXT,firstname);
        return this;
    }
    @Step("Input the KF path as: {lastname}")
    public AddUserController fillLastName(String lastname ) {
        fill(driver,getAddUserElem(driver).lastNameTXT,lastname);
        return this;
    }
    @Step("Input the KF path as: {email}")
    public AddUserController fillEmail(String email ) {
        fill(driver,getAddUserElem(driver).emailTXT,email);
        return this;
    }
    @Step("Input the KF path as: {description}")
    public AddUserController fillDescription(String description ) {
        fill(driver,getAddUserElem(driver).descriptionTXT,description);
        return this;
    }
    @Step("Check User must change password at next logon ")
    public AddUserController checkFinalPassword() {
        check(driver,getAddUserElem(driver).finalPWDCheckBox);
        return this;
    }
    @Step("Un-Check User must change password at next logon ")
    public AddUserController unCheckFinalPassword() {
        uncheck(driver,getAddUserElem(driver).finalPWDCheckBox);
        return this;
    }
    public AddUserController clickOnUserType(){
        click(driver,getAddUserElem(driver).userTypeListBox);
        return this;
    }
    @Step("Select the user type as : {userType}")
    public AddUserController selectUserType(UserData type) {

        switch (type){
            case REGULAR :
                select(getAddUserElem(driver).userTypeOpt,REGULAR.getValue());
                break;
            case AUTO:
                select(getAddUserElem(driver).userTypeOpt,AUTO.getValue());
                break;
            case TEMPORARY:
                select(getAddUserElem(driver).userTypeOpt, TEMPORARY.getValue());
                break;
            default:
                System.out.println(type + "NOT available");
                break;

        }
        return this;
    }
    @Step("Click on the Save button")
    public AddUserController clickOnSaveBtn(){
        click(driver,getAddUserElem(driver).saveBtn);
        return this;
    }


}
