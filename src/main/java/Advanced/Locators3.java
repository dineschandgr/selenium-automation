package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators3 {


    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        String name = "rahul";

        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String loginText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();

        System.out.println("loginText "+loginText);

        String anchorText = driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[1]")).getText();

        System.out.println("anchorText "+anchorText);


        //header/div/button[1]/parent::div/parent::header/a[1]
        driver.close();
        driver.quit();




    }


    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        String passwordText = driver.findElement(By.cssSelector("form p")).getText();

        //Please use temporary password 'rahulshettyacademy' to Login.

        String[] passwordArray = passwordText.split("'");

         // String[] passwordArray2 = passwordArray[1].split("'");

        // passwordArray2[0]

        String password = passwordArray[1].split("'")[0];

        return password;

        //0th index - Please use temporary password

        //1st index - rahulshettyacademy' to Login.


        //0th index - rahulshettyacademy

        //1st index - to Login.


    }
}

