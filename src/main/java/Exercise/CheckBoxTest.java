package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CheckBoxTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //*[@type='checkbox'][1]

        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

        Assert.assertEquals(driver.findElements(By.xpath("//*[@type='checkbox'][1]")).size(), 3);

        driver.close();
        driver.quit();

    }


}
