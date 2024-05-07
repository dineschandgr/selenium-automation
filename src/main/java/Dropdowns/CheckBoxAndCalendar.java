package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class CheckBoxAndCalendar {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        boolean radioSelected = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected();

        Assert.assertFalse(radioSelected);

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
        radioSelected = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected();
        Assert.assertTrue(radioSelected);

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

        driver.findElement(By.name("ctl00$mainContent$view_date1")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//td[@data-month='4']//a[text()='8']"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.name("ctl00$mainContent$view_date2")).click();

        driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//td[@data-month='5']//a[text()='12']"))
                        .click();

        List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar'] /a"));
        System.out.println("dates is "+dates.size());
        for(WebElement date : dates){
            System.out.println("text is "+date.getText());
            if(date.getText().equals("17")){
                date.click();
                break;
            }
        }



        boolean checkboxSelected = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected();

        Assert.assertFalse(checkboxSelected);

        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
        checkboxSelected = driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected();
        Assert.assertTrue(checkboxSelected);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@type='checkbox']"));

        for(WebElement checkbox : checkBoxes){
            System.out.println("checkbox text "+checkbox.getAttribute("name"));
        }

       // Assert.assertEquals().size(), 6);



        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000);

        for(int i = 0; i < 4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());




        driver.close();
        driver.quit();


    }
}
