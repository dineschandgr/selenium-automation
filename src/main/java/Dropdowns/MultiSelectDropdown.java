package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSelectDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.id("justAnInputBox")).click();

        //45 elements
        List<WebElement> dropDownOptions = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));

        List<String> optionsToBeSelected = Arrays.asList("choice 1", "choice 2", "choice 2 3", "choice 6 1","choice 6 2 1");

      /*  dropDownOptions.stream()
                .filter(e -> optionsToBeSelected.contains(e.getText()))
                .forEach(e -> e.click());
      */

        for(WebElement element : dropDownOptions) {
            //if(optionsToBeSelected.contains(element.getText())){
                element.click();
            //}
        }

        }




    }
