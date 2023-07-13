package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase11 {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
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
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible */

        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//img[@src='/get_product_picture/43']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).isDisplayed());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).
                sendKeys("cyuksel@gmail.com"+ Keys.ENTER);
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).
                isDisplayed());


    }
}
