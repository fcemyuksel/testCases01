package SeleniumJunit.IlkDersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme01 {
    WebDriver driver;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void deneme1() throws InterruptedException {

        driver.get("https://www.hepsiburada.com/");

        driver.findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        driver.findElement(By.id("txtUserName")).sendKeys("fcemyuksel@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.id("txtPassword")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"btnEmailSelect\"]")).click();




    }

    }
