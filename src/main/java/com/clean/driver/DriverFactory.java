package com.clean.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.clean.driver.DriverBase.readConfigFile;

public class DriverFactory {

    private  WebDriver webDriver;
    //Singleton Design Pattern
   WebDriver getDriver(){
        if(webDriver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            webDriver= new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
    WebDriver getDriver(String browserName) throws MalformedURLException {
        if(webDriver == null){

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if(browserName.equalsIgnoreCase(readConfigFile.chrome())) {
                WebDriverManager.chromedriver().setup();
                capabilities.setCapability("browserName", browserName);
            }else {
                WebDriverManager.firefoxdriver().setup();
                capabilities.setCapability("browserName",browserName);
            }

            webDriver = new RemoteWebDriver(new URL(readConfigFile.seleniumGridHub()),
                    capabilities);
            webDriver.manage().window().maximize();
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




}
