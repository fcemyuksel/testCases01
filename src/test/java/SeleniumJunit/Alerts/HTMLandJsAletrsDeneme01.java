package SeleniumJunit.Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HTMLandJsAletrsDeneme01 {
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
    public void test02() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='alertexamples']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//input[@id='confirmexample']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        String istenmeyenKelime= "successfuly";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='confirmexplanation']"));
        String actualYazi = sonucYaziElementi.getText();
        Thread.sleep(1000);
        Assert.assertFalse(actualYazi.contains(istenmeyenKelime));
        System.out.println(sonucYaziElementi.getText());

        driver.findElement(By.xpath("//input[@id='promptexample']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("Cem Yuksel");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String exceptedResult = "Cem Yuksel";
        WebElement sonucElementi = driver.findElement(By.xpath("//p[@id='promptreturn']"));
        String actualSonuc = sonucElementi.getText();
        Thread.sleep(2000);
        Assert.assertTrue(actualSonuc.contains(exceptedResult));
        System.out.println(sonucElementi.getText());

    }
}
