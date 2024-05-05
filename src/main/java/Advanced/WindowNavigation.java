package Advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowNavigation {


    public static void main(String[] args) throws InterruptedException {


       System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

       WebDriver driver = new ChromeDriver();

       driver.manage().window().maximize();

       //inbuilt wait will happen
       driver.get("http://google.com");

        //inbuilt wait will not happen
       driver.navigate().to("https://www.espncricinfo.com/");

       driver.navigate().back();

       driver.navigate().forward();

   }


}
