package com.clean.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private  WebDriver webDriver;
    private WebDriverWait wait;
    //Singleton Design Pattern
   WebDriver getDriver(){
        if(webDriver == null){
            WebDriverManager.chromedriver().setup();
            webDriver= new ChromeDriver();
        }
        return webDriver;
    }
    void quitDriver(){
        if (webDriver !=null){
            webDriver.quit();
            webDriver =null;
        }
    }
    WebDriverWait getWebDriverWait(){
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        }
        return wait;
    }



}
