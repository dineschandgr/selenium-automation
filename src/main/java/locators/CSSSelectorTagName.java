package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CSSSelectorTagName {
    public static void main(String[] args) throws InterruptedException {


        //tagname.classname  - button.signInBtn
        //id -> tagname#id - input#inputUsername
        //Tagname[attribute='value'] - input[placeholder='Username']

        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        //ask selenium to wait for sometime until page loads
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       /* driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();*/

        driver.get("https://github.com/");
        //Thread.sleep(3000);
        driver.findElement(By.className("HeaderMenu-link--sign-in")).click();


        // id -> tagname#id
        Thread.sleep(1000);
        //System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.id("login_field")).sendKeys("dineshchandgr@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Dineshch@8");
        driver.findElement(By.className("js-sign-in-button")).click();

        //Thread.sleep(3000);
        Thread.sleep(1000);
        driver.findElement(By.className("AppHeader-context-item-label")).click();

        //System.out.println(driver.findElement(By.className("js-flash-alert")).getText());

        driver.close();
        driver.quit();
    }
}
