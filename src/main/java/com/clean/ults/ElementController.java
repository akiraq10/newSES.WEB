package com.clean.ults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
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
            element.clear();
            element.sendKeys(textDatabase);

        }
    }


    public static void verify(WebDriver driver,WebElement element){

        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        assertTrue(element.isDisplayed(), "Test case is failed");
    }

    public static void verify(WebDriver driver, WebElement element, String expected) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expected);
    }

    public static void browseFile(String path) throws AWTException {
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        System.out.println(ss);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    public static void hover(WebDriver driver, WebElement element) {
        if (!element.isDisplayed()) {
            System.out.println("ERR | " + element + " Not Found.");

        } else {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

        }
    }
    public static void uncheck(WebDriver driver,WebElement element){
        if (!element.isDisplayed())
        {
            System.out.println("ERR | " + element + " Not Found.");
        }
        else{
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isSelected()){
                element.click();
            }else System.out.println(element + "was uncheck");



        }
    }
    public static void check(WebDriver driver,WebElement element){
        if (!element.isDisplayed())
        {
            System.out.println("ERR | " + element + " Not Found.");
        }
        else{
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
            if(!element.isSelected())
            {
                element.click();
            }else System.out.println(element + " was checked below");

        }
    }
    public static void select(WebElement element,String optionName){

        Select select = new Select(element);
        select.selectByVisibleText(optionName);



    }

}
