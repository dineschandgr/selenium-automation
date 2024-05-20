package Miscallaneous;

import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeOptions {

    public static void main(String[] args) {

// TODO Auto-generated method stub


        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

        Proxy proxy = new Proxy();

        proxy.setHttpProxy("ipaddress:4444");

        options.setCapability("proxy", proxy);

        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("download.default_directory", "/directory/path");

        options.setExperimentalOption("prefs", prefs);

        // FirefoxOptions options1 = new FirefoxOptions();

        // options1.setAcceptInsecureCerts(true);

        // EdgeOptions options2 = new EdgeOptions();

        options.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());

    }

}