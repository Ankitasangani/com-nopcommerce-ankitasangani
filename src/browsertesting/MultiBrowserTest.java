package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

public class MultiBrowserTest {

    // static variables
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // Nested if else to launch the browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //Open baseUrl
        driver.get(baseUrl);

        // Maximise the browser window
        driver.manage().window().maximize();

        System.out.println("The title of the page: " + driver.getTitle());  // get the title of the page
        System.out.println("The current URL:  " + driver.getCurrentUrl());  //get the current Url of the page
        System.out.println("The page source: " + driver.getPageSource());  // get page source

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F"); // Navigate to given Url
        System.out.println("Get current URl:" + driver.getCurrentUrl());  //get the current Url of the page
        driver.navigate().back(); // Navigate back to the home page.
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F"); // Navigate to the login page
        System.out.println("Get current URl:" + driver.getCurrentUrl());   //get the current Url of the page
        driver.navigate().refresh(); // Refresh the page
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com"); // Enter the email to email field
        driver.findElement(By.name("Password")).sendKeys("Prime123"); // Enter the password to password field
        driver.findElement(By.className("login-button")).click(); // Click on Login Button

        driver.close(); // close the current window where Selenium automation is running

    }
}
