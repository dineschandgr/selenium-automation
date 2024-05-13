package Synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class ShoppingCartExplicitWait {



    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        //System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //Thread.sleep(3000);

        addItems(driver,itemsNeeded);

        driver.findElement(By.xpath("//*[@class='cart-icon']")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath("//*[@class='cart-items'] //li[@class='cart-item'] //*[@class='product-remove'] "));
        System.out.println(cartItems.size());
        //Thread.sleep(3000);
        //remove last element in cart
        cartItems.get(0).click();

        driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoCode']")));
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshetty");

        driver.findElement(By.xpath("//*[@class='promoBtn']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//*[@class='promoInfo']")).getText());
    }

    public static  void addItems(WebDriver driver,String[] itemsNeeded)

    {

        int j=0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++) {

            //Brocolli - 1 Kg

            //Brocolli,    1 kg

            String[] name =products.get(i).getText().split("-");

            String formattedName = name[0].trim();

            //format it to get actual vegetable name

            //convert array into array list for easy search

            //  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName))

            {

                j++;

                //click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j == itemsNeeded.length)

                {

                    break;

                }

            }

        }

    }



}