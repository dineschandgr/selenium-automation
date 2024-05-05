package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropdownLooping {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000);

        for(int i = 0; i < 4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }


        driver.findElement(By.id("btnclosepaxoption")).click();


        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    }
}
