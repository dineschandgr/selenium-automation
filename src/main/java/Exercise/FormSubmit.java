package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class FormSubmit {

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        //WebDriver firefoxDriver = new ChromeDriver();
        //WebDriver edgeDriver = new EdgeDriver();

        //List<WebDriver> drivers = List.of(chromeDriver);

        //for(WebDriver driver : drivers) {
            driver.get("https://rahulshettyacademy.com/angularpractice/");
            //*[@type='checkbox'][1]

            driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input[1]")).sendKeys("Dineshchand");
            driver.findElement(By.name("email")).sendKeys("test@gmail.com");
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
            driver.findElement(By.id("exampleCheck1")).click();

            WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

            Select value = new Select(dropdown);
            value.selectByVisibleText("Female");
            driver.findElement(By.id("inlineRadio2")).click();
            driver.findElement(By.xpath("//*[@type='date']")).sendKeys(("28/04/1988"));

            driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
            System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
        }


    }



