package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropDown = new Select(staticDropDown);

        dropDown.selectByIndex(3);

        //System.out.println(dropDown.getFirstSelectedOption().getText());

        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "USD");

        dropDown.selectByVisibleText("AED");

        //System.out.println(dropDown.getFirstSelectedOption().getText());

        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "AED");

        dropDown.selectByValue("INR");

        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Select");

        //System.out.println(dropDown.getFirstSelectedOption().getText());

    }
}
