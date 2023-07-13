package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase10 {
    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){driver.quit();}

    @Test
    public void test01() throws InterruptedException {
    /*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible */

        driver.get("http://automationexercise.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@src='/get_product_picture/43']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("cyuksel@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        System.out.println(driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).
                isDisplayed());
    }
}
