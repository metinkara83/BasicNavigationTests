package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browserName){
        String osName = System.getProperty("os.name");
        String lowerOSName = osName.toLowerCase();
        browserName=browserName.toLowerCase();
        if ((lowerOSName.contains("windows") && browserName.equals("safari")) ||(lowerOSName.contains("mac") && browserName.equals("edge"))){
            return null;
        }
        else if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        else if (browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else if (browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        else {
            return null;
        }
    }
}
