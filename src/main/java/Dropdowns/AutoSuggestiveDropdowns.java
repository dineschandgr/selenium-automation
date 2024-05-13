package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoSuggestiveDropdowns {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);

        List<WebElement> optionsList = driver.findElements(By.xpath("//li[@class='ui-menu-item'] /a"));

        for(WebElement e :  optionsList){
            if(e.getText().equalsIgnoreCase("India")){
                e.click();
                break;
            }
        }

        //CSS Selector
        //driver.findElement(By.cssSelector("*[@class='ui-menu-item'] a"));

        Thread.sleep(2000);

        /*for(int i = 0; i < 4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }*/


       // driver.findElement(By.id("btnclosepaxoption")).click();


        System.out.println("auto suggest "+driver.findElement(By.id("autosuggest")).getText());

    }
}
