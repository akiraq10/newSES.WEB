package com.clean.ults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ElementController {


    public static void click(WebDriver driver,WebElement element){
        if (!element.isDisplayed())
        {
            System.out.println("ERR | " + element + " Not Found.");
        }
        else{
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();

        }
    }
    public static void fill(WebDriver driver,WebElement element,String textDatabase){
        if (!element.isDisplayed())
        {
            System.out.println("ERR | " + element + " Not Found.");
        }
        else{
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(textDatabase);

        }
    }

    public static void verify(WebDriver driver,WebElement element){

        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        assertTrue(element.isDisplayed(),"aaaaaa");
    }

}
