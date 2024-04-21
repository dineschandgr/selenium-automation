package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ForgotPasswordLink {
    public static void main(String[] args) throws InterruptedException {


        //tagname.classname  - button.signInBtn
        //id -> tagname#id - input#inputUsername
        //Tagname[attribute='value'] - input[placeholder='Username']

        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //ask selenium to wait for sometime until page loads

        driver.get("https://github.com/");
        driver.findElement(By.className("HeaderMenu-link--sign-in")).click();
        driver.findElement(By.linkText("Forgot password?")).click();

        driver.findElement(By.xpath("//input[@placeholder='Enter your email address']")).sendKeys("test@test.com");

        /*driver.close();
        driver.quit();*/
    }
}
