package Synchronization;

import java.time.Duration;
import java.util.Arrays;

        import java.util.List;

        import org.openqa.selenium.By;

        import org.openqa.selenium.WebDriver;

        import org.openqa.selenium.WebElement;

        import org.openqa.selenium.chrome.ChromeDriver;


public class ShoppingCartImplicitWait {



    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        //System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<String> itemsNeeded = Arrays.asList("Cucumber","Brocolli","Beetroot");

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //Thread.sleep(3000);

        addItems(driver,itemsNeeded);

        driver.findElement(By.xpath("//*[@class='cart-icon']")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath("//*[@class='cart-items'] //li[@class='cart-item'] //*[@class='product-remove'] "));
        System.out.println(cartItems.size());

        //Thread.sleep(3000);
        //remove first element in cart
        cartItems.get(0).click();

        driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();

        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshetty");

        driver.findElement(By.xpath("//*[@class='promoBtn']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='promoInfo']")).getText());

    }

    public static void addItems(WebDriver driver,List<String> itemsNeededList)

    {

        int j=0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++) {

            //Brocolli - 1 Kg

            //Brocolli,    1 kg

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();

            //format it to get actual vegetable name

            //  check whether name you extracted is present in arrayList or not-

            if(itemsNeededList.contains(formattedName)) {
                j++;

                //click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j == itemsNeededList.size()) {
                    break;
                }

            }

        }

    }



}