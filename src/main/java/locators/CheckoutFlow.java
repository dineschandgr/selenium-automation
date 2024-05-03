package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckoutFlow {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/dineshchandgeetharavichandran/Desktop/Dinesh/Selenium/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        User user = getCredentials();

        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(user.getUserName());
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(user.getPassword());
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//span[@data-test='title']")).getText();

        if (text.equalsIgnoreCase("Products")) {
            System.out.println("login success");
        } else {
            System.out.println("fail");
        }

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
        String inventoryDesc = driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
        String inventoryPrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']")).getText();

        System.out.println("inventoryDesc " + inventoryDesc);
        System.out.println("inventoryPrice " + inventoryPrice);


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


        System.out.println("inventoryPriceSummary " + inventoryPriceSummary);
        System.out.println("shippingInfo " + shippingInfo);
        System.out.println("totalPayment " + totalPayment);

        if (inventoryPrice.equalsIgnoreCase(inventoryPriceSummary)) {
            System.out.println("checkout flow success");
        }


        //click finish button
        driver.findElement(By.id("finish")).click();

        driver.close();
        driver.quit();
    }


    public static User getCredentials() {

        String url = "jdbc:mysql://localhost:3306/test_new_schema";
        String dbUsername = "root";
        String dbPassword = "password";

        User user = null;

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {

            // Creating Database Connection

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database!");

            Statement stmt = connection.createStatement();

            String selectSql = "SELECT * FROM user where type = 'standard'";

            ResultSet rs = stmt.executeQuery(selectSql);

            while (rs.next()) {
                //Display values
                String userName = rs.getString("username");
                String password = rs.getString("password");
                user = new User(userName,password);

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

}

class User{
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
