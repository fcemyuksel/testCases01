package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase12 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){}

    @Test
    public void test01() throws InterruptedException {

/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price */

        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//*[@src='/get_product_picture/43']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        Thread.sleep(5000);

        WebElement ikinciUrun=driver.findElement(By.xpath("(//a[text()='Add to cart'])[2]"));
        Actions actions=new Actions(driver);

        actions.moveToElement(ikinciUrun).click().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();


    }


}
