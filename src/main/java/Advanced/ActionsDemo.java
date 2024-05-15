package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class ActionsDemo {

    public static void main(String[] args) {

// TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")))
                .click().keyDown(Keys.SHIFT).sendKeys("cricket").keyDown(Keys.BACK_SPACE).build().perform();

        action.moveToElement(driver.findElement(By.xpath("//span[text()='Login']"))).build().perform();
        //action.moveToElement().build().perform();
        System.out.println("end of program");

    }

}