package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase3 {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
*/
WebDriver driver;

@Before

    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
@After

    public void tearDown(){driver.quit();}

    @Test
    public void test03() throws InterruptedException {

    driver.get("https://automationexercise.com/");
    driver.findElement(By.xpath("//p[normalize-space()='GRAPHIC DESIGN MEN T SHIRT - BLUE']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
    driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("abc@abc.com");
    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1234");
    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).isDisplayed();


    }
}

