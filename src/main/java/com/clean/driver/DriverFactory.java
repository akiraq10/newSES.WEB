package com.clean.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.clean.driver.DriverBase.readConfigFile;

public class DriverFactory {

    private  WebDriver driver;

    //Singleton Design Pattern
    public WebDriver getChromrDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        return driver;
    }
    public WebDriver getDriver(Browser browser,String url) throws MalformedURLException {
        String remote_url=readConfigFile.seleniumGridHub();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(driver == null){

            URL webDriverGripServer=null;
            try{
                webDriverGripServer=new URL(remote_url);
            }catch (Exception e){
                e.printStackTrace();
            }

            if(webDriverGripServer==null){
                throw new IllegalArgumentException("[ERR] the driver cannot null");
            }

            switch (browser){
                case chrome:
                     capabilities.setBrowserName(browser.toString());
                    break;
                case firefox:
                    capabilities.setBrowserName(browser.toString());
                    break;
                case MicrosoftEdge:
                    capabilities.setBrowserName(browser.toString());
                    break;
                default: throw new IllegalArgumentException("[ERR] the browser cannot null");
            }

            try {
                driver = new RemoteWebDriver(webDriverGripServer, capabilities);
                driver.get(url);
                driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return driver;
    }
    public void quitDriverSession(){
        if (driver !=null){
            driver.quit();
            driver =null;
        }
    }




}
