package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Frames {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");

        int iframesSize = driver.findElements(By.tagName("iframe")).size();
        System.out.println("iframe size is "+iframesSize);

        //to switch to the frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        //driver.switchTo().frame(0);

        driver.findElement(By.id("draggable")).click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);

        action.dragAndDrop(source,target).build().perform();

        //to come back to the html page
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(" //a[text()='Default functionality']")).click();

    }

}