package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class JavascriptExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(5000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");

        List<WebElement> tableElements = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        // xpath //div[@class='tableFixHead'] //td[4]

        int sum = 0;
        for(WebElement e : tableElements){
            sum = sum + Integer.parseInt(e.getText());
        }

        System.out.println("sum is "+sum);
        int expectedVal = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        System.out.println("expectedVal is "+expectedVal);

        Assert.assertEquals(sum, expectedVal);

        driver.close();
        driver.quit();

    }

}