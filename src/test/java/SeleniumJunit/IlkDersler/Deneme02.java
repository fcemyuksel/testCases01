package SeleniumJunit.IlkDersler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class Deneme02 {
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
        public void Deneme02() throws InterruptedException {

            driver.get("https://www.n11.com/");

            driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div[5]/div/div/div/a[2]")).click();
            driver.findElement(By.xpath("//input[@id='email']")).click();
            driver.findElement(By.name("email")).sendKeys("fcemyuksel@gmail.com");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
            driver.findElement(By.name("password")).sendKeys("123456");
            driver.findElement(By.className("rememberMe")).click();
            driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();
            Thread.sleep(3000);


        }
    }

