package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class SynchronizationPractise {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.xpath("//*[@value='user']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

        driver.findElement(By.id("okayBtn")).click();

        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Teacher");
        dropdown.selectByVisibleText("Student");

        Assert.assertTrue(dropdown.getFirstSelectedOption().getText().equalsIgnoreCase("student"));
        driver.findElement(By.id("terms")).click();

        Assert.assertTrue(driver.findElement(By.id("terms")).isSelected());

        driver.findElement(By.id("signInBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));

        System.out.println("size of items "+driver.findElements(By.xpath("//button[@class='btn btn-info']")).size());

        List<WebElement> itemsList = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

        for(WebElement item : itemsList){
            item.click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

        driver.findElement(By.id("country")).sendKeys("Ind");

        w.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='suggestions'] /ul /li /a"))));

        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='suggestions'] /ul /li /a"));

        System.out.println("options list size "+optionsList.size());
        for(WebElement e :  optionsList){
            if(e.getText().equalsIgnoreCase("India")){
                System.out.println("selected text "+e.getText());
                e.click();
                break;
            }
        }

      Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                if(driver.findElement(By.id("checkbox2")).isDisplayed()){
                    return driver.findElement(By.id("checkbox2"));
                }else{
                    return null;
                }
            }
        });

        System.out.println("is element displayed "+driver.findElement(By.id("checkbox2")).isDisplayed());
        //Thread.sleep(2000);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='checkbox checkbox-primary'] /input")));

        driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary'] /input")).click();

        driver.findElement(By.xpath("//input[@value='Purchase']")).click();
    }

}
