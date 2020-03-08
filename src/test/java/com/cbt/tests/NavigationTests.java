package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NavigationTests {

    public static void main(String[] args) {

        List<String> browsers = new ArrayList<>();
        browsers.addAll(Arrays.asList("chrome","firefox","edge"));

        for (int i = 0 ; i < browsers.size() ; i++){
            testCases(browsers.get(i));
        }
    }

    public static void testCases(String browser){
        try{
            WebDriver driver = BrowserFactory.getDriver(browser);
            driver.get("https://google.com");
            String titleGoogle = driver.getTitle();
            driver.get("https://etsy.com");
            String titleEtsy = driver.getTitle();
            driver.navigate().back();
            StringUtility.verifyEquals(titleGoogle, driver.getTitle());
            driver.navigate().forward();
            StringUtility.verifyEquals(titleEtsy, driver.getTitle());
            driver.quit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
