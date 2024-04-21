package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ForgotPasswordLink2 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("dineshchandgr@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("dineshchandgr1@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("12345678");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        //driver.findElement(By.className("signInBtn")).click();

        driver.findElement(By.xpath("//form/input[3]")).clear();
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        String pwd = driver.findElement(By.cssSelector(".infoMsg")).getText();
        String pwd1 = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println("pwd is "+pwd);
        System.out.println("pwd 1 is "+pwd1);
    }
}
