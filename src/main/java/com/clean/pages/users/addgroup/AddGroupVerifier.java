package com.clean.pages.users.addgroup;



import org.openqa.selenium.WebDriver;
import static com.clean.ults.ElementController.*;
import static com.clean.pages.users.addgroup.AddGroupElement.getElement;

public class AddGroupVerifier {
    private WebDriver driver;

    public AddGroupVerifier(WebDriver driver) {
        this.driver = driver;
    }


    public AddGroupVerifier isCheckAddGroupSuccess(String expected){
        verify(driver,getElement(driver).alertCreateGroupSuccess,expected);
        return this;
    }
}
