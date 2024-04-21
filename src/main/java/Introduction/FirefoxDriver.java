package Introduction;

import org.openqa.selenium.WebDriver;

public class FirefoxDriver {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/geckodriver");

        WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();

        driver.get("https://www.facebook.com/");
        System.out.println("Title is "+driver.getTitle());
        System.out.println("Current URL is "+driver.getCurrentUrl());
        //closes original browser
       // driver.close();

        //closes all windows opened by SELENIUM
        driver.quit();

    }
}
