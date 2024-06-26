import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class ECommerceTesting {

    public static void main(String[] args) {

        String productName = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");

        driver.manage().window().maximize();

        driver.findElement(By.id("userEmail")).sendKeys("dineshchandgr@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Password@1");
        driver.findElement(By.id("login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until((ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        boolean productFound = driver.findElements(By.cssSelector(".cartSection h3")).stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(productFound);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow")));
        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        driver.findElement(By.xpath("//div[@class='user__address']//div//section//button[2]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();

        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase( "THANKYOU FOR THE ORDER"));

        driver.close();
        driver.quit();

    }


}
