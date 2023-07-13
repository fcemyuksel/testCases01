package AutomationExercise;

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

public class TestCase1 {

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

         /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button   */

        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//p[normalize-space()='GRAPHIC DESIGN MEN T SHIRT - BLUE']")).
                click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();
        String exceptedResult= "New User Signup!";
        String actualResult= "New User Signup!";
        Assert.assertEquals(exceptedResult,actualResult);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("cem");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).
                sendKeys("cemy@gmail.com");
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).
                click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).
                isDisplayed());
        String exceptedResult1="ENTER ACCOUNT INFORMATION";
        String actualResult1="ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(exceptedResult1,actualResult1);
        driver.findElement(By.xpath("//input[@id='id_gender1']")).
                click();
        driver.findElement(By.xpath("//input[@id='password']")).
                sendKeys("1234");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("26");
        driver.findElement(By.xpath("//select[@id='months']")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[8]")).click();
        driver.findElement(By.xpath("//select[@id='years']")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[51]")).click();
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("cem");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("yuksel");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("schering plough");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123 street");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("izmir");
        driver.findElement(By.xpath("//*[@id=\"country\"]/option[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("izmir");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("izmir");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("35000");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("53212345678");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        System.out.println(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();


       Thread.sleep(5000);
        driver.get("http://automationexercise.com");


        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();


    }

}



