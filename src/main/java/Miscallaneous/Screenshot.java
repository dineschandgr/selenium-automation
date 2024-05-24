package Miscallaneous;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class Screenshot {

    public static void main(String[] args) throws IOException {

// TODO Auto-generated method stub


        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("http://google.com");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/src/main/screenshots/screenshot1.png"));

        System.out.println(driver.getTitle());

    }

}