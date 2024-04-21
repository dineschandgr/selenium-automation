import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/dineshchandgeetharavichandran/Downloads/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://github.com/login");

        driver.manage().window().maximize();


        WebElement button = driver.findElement(By.id("forgot-password"));

        button.click();

        String pageTitle = driver.getTitle();

        System.out.println("Page Title: " + pageTitle);



        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        driver.quit();


    }
}
