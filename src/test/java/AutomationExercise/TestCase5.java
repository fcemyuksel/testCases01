package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase5 {

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
    public void test05() throws InterruptedException {

/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
 */

        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//p[normalize-space()='GRAPHIC DESIGN MEN T SHIRT - BLUE']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("cem");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("cemy@gmail.com");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).isDisplayed();

    }
}
