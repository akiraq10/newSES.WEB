package com.clean.ults;

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

import static org.testng.Assert.*;

public class ElementController {

    private static void waitForElementVisibility(WebDriver driver, WebElement elementName){
        try {
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(elementName));
        }catch (Exception e){
            fail("ERR| " +elementName + " Not displayed. Please recheck the locator");
            e.printStackTrace();
        }


    }
    private static void waitForElementClickAble(WebDriver driver, WebElement elementName){
        try {
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(elementName));
        }catch (Exception e)
        {
            fail("ERR| " +elementName + " Not displayed. Please recheck the locator");
            e.printStackTrace();
        }

    }


    public static void click(WebDriver driver,WebElement element){
        waitForElementClickAble(driver,element);
        element.click();


    }
    public static void fill(WebDriver driver,WebElement element,String textDatabase){
        waitForElementVisibility(driver,element);
        element.clear();
        element.sendKeys(textDatabase);


    }


    public static void verify(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);
        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else
        {

            assertTrue(element.isDisplayed(), "Test case is failed");
        }

    }

    public static void verifyElementNotDisplay(WebDriver driver,WebElement element){
        if (!element.isDisplayed())
        {
            assertFalse(element.isDisplayed(), "Test case is failed");
        }
        else fail("ERR| " + element + " is Found");

    }

    public static void verify(WebDriver driver, WebElement element, String expected) {
       waitForElementVisibility(driver,element);
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
        waitForElementClickAble(driver,element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }
    public static void uncheck(WebDriver driver,WebElement element){
        waitForElementClickAble(driver,element);
        try{
            if (element.isSelected()){
                element.click();
        }
            else System.out.println(element + "was uncheck");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void check(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);

        try{
            if(!element.isSelected())
            {
                element.click();
            }else System.out.println(element + " was checked below");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
    public static void select(WebElement element,String optionName){

        Select select = new Select(element);
        select.selectByVisibleText(optionName);

    }
    public static void selectOption(WebDriver driver,WebElement comboList,String optionName){
        waitForElementVisibility(driver,comboList);
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
                row.click();
                break;
            }
        }
    }

}
