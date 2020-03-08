package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        Set<String> titles = new HashSet<>();
        Set<Boolean> URLStartVerification = new HashSet<>();
        for (int i = 0 ; i < urls.size() ; i++){
            driver.get(urls.get(i));
            titles.add(driver.getTitle());
            URLStartVerification.add(driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com"));
        }

        System.out.println(titles);
        System.out.println(URLStartVerification);
        /**
         * Verification of all having same title
         * As Set Collection does not hold duplicated values,
         * if the titles.size() is 1, that means that they all have the same title
         */
        if (titles.size()==1){
            System.out.println("All URLs have the same title :: TEST PASSED");
        }
        else {
            System.out.println("All URLs DO NOT have the same title :: TEST FAILED");
        }

        /**
         * Verification of all URLs start with ...
         * As Set Collection does not hold duplicated values,
         * if the URLStartVerification.size() is 2, that means that it contains both true and false
         * if the URLStartVerification.size() is 1, and it contains TRUE that means all URLs start with same desired URL
         */
        if (URLStartVerification.size()==1 && URLStartVerification.contains(Boolean.TRUE)){
            System.out.println("All URLs of all pages start with \'http://practice.cybertekschool.com\' :: TEST PASSED");
        }
        else {
            System.out.println("All URLs of all pages DO NOT start with \'http://practice.cybertekschool.com\' :: TEST FAILED");
        }

        driver.quit();
    }
}
