package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase6 {
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
    public void test06() throws InterruptedException {

        /*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
         */

        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//p[normalize-space()='GRAPHIC DESIGN MEN T SHIRT - BLUE']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("cem");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("cemy@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Move to UAE");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("asdfg");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='upload_file']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='submit']")).click();





    }
}
