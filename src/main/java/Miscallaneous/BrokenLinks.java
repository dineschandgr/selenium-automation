package Miscallaneous;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class BrokenLinks {

    public static void main(String[] args) throws IOException {

// TODO Auto-generated method stub


        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //get all urls using selenium
        String url = driver.findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println("response code is "+responseCode);

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();

        for(WebElement link : links){
            String url1 = link.getAttribute("href");
            conn = (HttpURLConnection) new URL(url1).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            responseCode = conn.getResponseCode();

            System.out.println("resp code is "+responseCode);
            softAssert.assertTrue(responseCode < 400, " The link with Text "+link.getText()+" is broken with code " +responseCode);

           /* if(responseCode > 400) {
                System.out.println("broken link is " +url1+ "status code "+responseCode);
                softAssert.assertTrue(false);
            }
            */



        }
        softAssert.assertAll();


        driver.close();
        driver.quit();

    }

}