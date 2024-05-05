package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IDAndNameLocators {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //<input type="password" class="placeholder="Password" name="inputPassword" value="" xpath="1">


        driver.findElement(By.id("inputUsername")).sendKeys("test");
        String text = driver.findElement(By.id("inputUsername")).getText();

        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        text = driver.findElement(By.className("error")).getText();
        System.out.println("text is "+text);

        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        text = driver.findElement(By.cssSelector("p.infoMsg")).getText();

        System.out.println("text "+text);


        //driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        //using parent child
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();


        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();


        //button[@class='submit signInBtn']
        //driver.findElement(By.xpath("//button[@class='submit signInBtn'")).click();

        //css selector regex
        //driver.findElement(By.cssSelector("button[class*='signIn']")).click();

        //xpath regex
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        driver.close();

        driver.quit();

    }
}
