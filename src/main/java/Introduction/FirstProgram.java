package Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstProgram {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        System.out.println("Title is "+driver.getTitle());
        System.out.println("Current URL is "+driver.getCurrentUrl());
        System.out.println("Page Source is "+driver.getPageSource());
        //closes original browser
        driver.close();

        //closes all windows opened by SELENIUM
        driver.quit();

    }
}
