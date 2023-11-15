package com.clean.ults;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
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
import java.util.List;

import static com.clean.listener.ListenerEx.extentTest;
import static org.testng.Assert.*;

public class ElementController {



    private static WebElement waitForElementVisibility(WebDriver driver, WebElement elementName){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(elementName));
    }
    private static WebElement waitForElementClickAble(WebDriver driver, WebElement elementName){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(elementName));
    }

    public static void click(WebDriver driver,WebElement element){
        waitForElementClickAble(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");

        }
        else{
            extentTest.get().log(Status.INFO,"Click on the " + element.getText());
            element.click();

        }
    }
    public static void fill(WebDriver driver,WebElement element,String textDatabase){
        waitForElementVisibility(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else{
            extentTest.get().log(Status.INFO,"Enter the  " + textDatabase);
            element.clear();
            element.sendKeys(textDatabase);

        }
    }


    public static void verify(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else {
            extentTest.get().log(Status.INFO,"Verify the " + element.getText() + " is Displayed");
            assertTrue(element.isDisplayed(), "Test case is failed");
        }
    }
    public static void verifyElementNotDisplay(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);
        if (!element.isDisplayed())
        {
            assertFalse(element.isDisplayed(), "Test case is failed");
        }
        else fail("ERR| " + element + " is Found");

    }

    public static void verify(WebDriver driver, WebElement element, String expected) {
        waitForElementVisibility(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else assertEquals(element.getText(), expected);
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
        waitForElementClickAble(driver,element);
        if (!element.isDisplayed()) {
            fail("ERR| " + element + " Not Found");

        } else {
            extentTest.get().log(Status.INFO,"Hover mouse on the " + "' " +element.getText() +" '");

            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();

        }
    }
    public static void uncheck(WebDriver driver,WebElement element){
        waitForElementClickAble(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else{
            if (element.isSelected()){
                extentTest.get().log(Status.INFO,"Uncheck the " + element.getText());
                element.click();
            }else System.out.println(element + "was uncheck");
        }
    }
    public static void check(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else{
            if(!element.isSelected())
            {
                extentTest.get().log(Status.INFO,"Check on the " + element.getText());
                element.click();
            }else System.out.println(element + " was checked below");

        }
    }
    public static void select(WebElement element,String optionName){
        extentTest.get().log(Status.INFO,"Select the " + optionName +" option");
        Select select = new Select(element);
        select.selectByVisibleText(optionName);

    }
    public static void selectOption(WebDriver driver,WebElement comboList,String optionName){
        Actions action =new Actions(driver);

        if (comboList.getText().equals(optionName))
            return ;
        else{
            click(driver,comboList);
            try{

                WebElement option=driver
                        .findElement
                        (By.xpath
                        ("//div[@class='k-animation-container']" +
                                "/div/div[@class='k-list-scroller']/ul/li[text()='" +
                                optionName +
                                "']"));

                action.moveToElement(option).perform();
                if(!option.isDisplayed()){
                    fail("ERR| " + comboList + " Not Found");
                    return;
                }else{
                    extentTest.get().log(Status.INFO,"Select the " + optionName +" option");
                    waitForElementClickAble(driver,option);
                    click(driver,option);
                }

            }catch (Exception e){e.getStackTrace();}

        }
    }
    public static void selectElementInTable(WebDriver driver, WebElement  table,String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        List<WebElement> rows = table.findElements(By.xpath(".//td"));
        for(WebElement row : rows){
            if (row.getText().equals(value))
            {
                extentTest.get().log(Status.INFO,"Select the " + value );
                row.click();
                break;
            }
        }
    }

}
