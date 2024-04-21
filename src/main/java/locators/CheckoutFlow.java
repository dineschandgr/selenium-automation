package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckoutFlow {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//span[@data-test='title']")).getText();

        if(text.equalsIgnoreCase("Products")){
            System.out.println("login success");
        }else{
            System.out.println("fail");
        }

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
        String inventoryDesc = driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
        String inventoryPrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();

        System.out.println("inventoryDesc "+inventoryDesc);
        System.out.println("inventoryPrice "+inventoryPrice);


        //checkout
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Dinesh");
        driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys("Chand");
        driver.findElement(By.id("postal-code")).sendKeys("641004");

        //click continue button
        driver.findElement(By.id("continue")).click();

        //Summary
        Thread.sleep(2000);
        String inventoryPriceSummary = driver.findElement(By.cssSelector("div[data-test='inventory-item-price']")).getText();
        String shippingInfo = driver.findElement(By.cssSelector("div[data-test='shipping-info-label']")).getText();
        String totalPayment = driver.findElement(By.cssSelector("div[data-test='total-label']")).getText();


        System.out.println("inventoryPriceSummary "+inventoryPriceSummary);
        System.out.println("shippingInfo "+shippingInfo);
        System.out.println("totalPayment "+totalPayment);

        if(inventoryPrice.equalsIgnoreCase(inventoryPriceSummary)){
            System.out.println("checkout flow success");
        }


        //click finish button
        driver.findElement(By.id("finish")).click();

        driver.close();
        driver.quit();
    }
}
