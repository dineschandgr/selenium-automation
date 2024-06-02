import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    @Test()
    public class TestCheckoutFlow {

        WebDriver driver;
        String inventoryPrice = "";

        @BeforeClass
        public void testSetup() {
           // System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        @BeforeMethod
        public void openBrowser() throws InterruptedException {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(3000);
            System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
        }

        @Test(description="Login Page", priority = 0)
        public void login() throws InterruptedException {
            driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("standard_user");
            driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }

        @Test(description="This method validates the sign in functionality", priority = 1, dependsOnMethods = "login")
        public void signIn() throws InterruptedException {
          /*  driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("standard_user");
            driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();*/

            System.out.println("in productn page "+driver.getCurrentUrl());
            Thread.sleep(2000);
            String text = driver.findElement(By.xpath("//span[@data-test='title']")).getText();

            Assert.assertEquals(text, "Products");

            driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

            driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();

            String inventoryDesc = driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
            inventoryPrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();

            Reporter.log("inventoryDesc "+inventoryDesc);
            Reporter.log("inventoryPrice "+inventoryPrice);
            driver.findElement(By.id("checkout")).click();

            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Dinesh");
            driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys("Chand");
            driver.findElement(By.id("postal-code")).sendKeys("641004");

            //click continue button
            driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);

            String inventoryPriceSummary = driver.findElement(By.cssSelector("div[data-test='inventory-item-price']")).getText();
            String shippingInfo = driver.findElement(By.cssSelector("div[data-test='shipping-info-label']")).getText();
            String totalPayment = driver.findElement(By.cssSelector("div[data-test='total-label']")).getText();

            System.out.println("inventoryPriceSummary "+inventoryPriceSummary);
            System.out.println("shippingInfo "+shippingInfo);
            System.out.println("totalPayment "+totalPayment);

            Assert.assertEquals(inventoryPrice, inventoryPriceSummary);

            //click finish button
            driver.findElement(By.id("finish")).click();

        }

        @Test(description="Product Page", priority = 1, enabled = false)
        public void productPage() throws InterruptedException {

            System.out.println("in product page " +driver.getCurrentUrl());
            Thread.sleep(2000);
            String text = driver.findElement(By.xpath("//span[@data-test='title']")).getText();

            Assert.assertEquals(text, "Products");

            driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

            driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();

        }

        @Test(description="Cart Process",priority = 2, enabled = false)
        public void cartPage()
        {
            String inventoryDesc = driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
            inventoryPrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();

            Reporter.log("inventoryDesc "+inventoryDesc);
            Reporter.log("inventoryPrice "+inventoryPrice);
            driver.findElement(By.id("checkout")).click();
        }

        @Test(description="Address Page",priority = 3, enabled = false)
        public void fillAddress() throws InterruptedException {

            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Dinesh");
            driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys("Chand");
            driver.findElement(By.id("postal-code")).sendKeys("641004");

            //click continue button
            driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);

        }

        @Test(description="Summary Page",priority = 4, enabled = false)
        public void summaryPage() throws InterruptedException {

            String inventoryPriceSummary = driver.findElement(By.cssSelector("div[data-test='inventory-item-price']")).getText();
            String shippingInfo = driver.findElement(By.cssSelector("div[data-test='shipping-info-label']")).getText();
            String totalPayment = driver.findElement(By.cssSelector("div[data-test='total-label']")).getText();

            System.out.println("inventoryPriceSummary "+inventoryPriceSummary);
            System.out.println("shippingInfo "+shippingInfo);
            System.out.println("totalPayment "+totalPayment);

            Assert.assertEquals(inventoryPrice, inventoryPriceSummary);

            //click finish button
            driver.findElement(By.id("finish")).click();

        }

        @AfterMethod
        public void postSignUp()
        {
            System.out.println("end " +driver.getCurrentUrl());

        }

        @AfterClass
        public void afterClass()
        {
            driver.close();
            driver.quit();
        }

    }

