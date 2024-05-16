package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksCount {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String click = Keys.chord(Keys.SHIFT, Keys.ADD);
        driver.findElement(By.id("autocomplete")).sendKeys(click);

        System.out.println("count of links "+driver.findElements(By.tagName("a")).size());
        System.out.println("count of tables "+driver.findElements(By.tagName("table")).size());

        //limit scope of web driver to footer

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //limit scope of web driver to a column in footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        int size = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(size);

        //check if all links are working

        //Exception in thread "main" org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
        for(int i = 1; i < size; i++) {

            // use Keys.COMMAND for MAC

            String clickonTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            System.out.println("element " + columnDriver.findElements(By.tagName("a")).get(i).getText());
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
            Thread.sleep(5000);
        }

        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);

        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println("title of tab is " + driver.getTitle());
        }

        String parent = handlesList.get(0);
        driver.switchTo().window(parent);
        System.out.println("title of parent is " + driver.getTitle());

        driver.close();
        driver.quit();

    }


}
