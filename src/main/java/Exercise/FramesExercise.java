package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class FramesExercise {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        String click = Keys.chord(Keys.COMMAND, Keys.ENTER);

        driver.findElement(By.xpath("//a[text()='Nested Frames']")).sendKeys(click);

        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

        Iterator<String> it = windows.iterator();

        String parentId = it.next();

        String childId = it.next();

        driver.switchTo().window(childId);

        int iframesSize = driver.findElements(By.tagName("iframe")).size();
        System.out.println("iframe size is "+iframesSize);

        driver.switchTo().frame(driver.findElement(By.xpath("//frameset/frame[1]")));
        driver.switchTo().frame("frame-middle");

        System.out.println("val is "+driver.findElement(By.id("content")).getText());

        driver.switchTo().window(parentId);

        driver.close();
        driver.quit();
    }

}