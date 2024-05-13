package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CheckBoxTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //*[@type='checkbox'][1]

        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

        Assert.assertEquals(driver.findElements(By.xpath("//*[@type='checkbox'][1]")).size(), 3);

        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        Thread.sleep(2000);
        //List<WebElement> optionsList = driver.findElements(By.xpath("//*[@class='ui-menu-item'] /div"));

        /*for(WebElement e :  optionsList){
            if(e.getText().equalsIgnoreCase("Indonesia")){
                e.click();
                break;
            }
        }*/

        driver.findElements(By.xpath("//*[@class='ui-menu-item'] /div"))
                .stream().filter(e -> e.getText().equalsIgnoreCase("Indonesia")).findFirst().get().click();

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdownOptions = new Select(dropdown);
        dropdownOptions.selectByVisibleText("Option3");

       Thread.sleep(2000);
       //Assert.assertEquals(driver.findElement(By.id("autocomplete"))., "Indonesia");

        driver.close();
        driver.quit();

    }


}
