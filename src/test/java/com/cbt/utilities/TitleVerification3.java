package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com");
        for (String eachURL: urls) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(eachURL);
            if (eachURL.substring(8,eachURL.indexOf(".")).contains(driver.getTitle().replace(" ","").toLowerCase())){
                System.out.println("TEST PASSED - The URL contains the Title");
                System.out.println("===========");
            }
            else {
                System.out.println("TEST FAILED");
                System.out.println(eachURL);
                System.out.println(driver.getTitle());
                System.out.println("=====================");
            }
            driver.quit();
        }

    }
}
