package com.clean.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
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
    WebDriver getDriver(String browserName) throws MalformedURLException {
        if(webDriver == null){

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if(browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                capabilities.setCapability("browserName", browserName);
            }else {
                WebDriverManager.firefoxdriver().setup();
                capabilities.setCapability("browserName",browserName);
            }

            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/"),
                    capabilities);
            return webDriver;


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
