package SeleniumJunit.Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JsAlerts03TextInput {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("merhaba cem bey");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String expectedResult = "merhaba cem bey";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText();
        System.out.println(sonucYaziElementi.getText());

        Assert.assertTrue(actualResultYazisi.contains(expectedResult));

        Thread.sleep(5000);
    }
}
