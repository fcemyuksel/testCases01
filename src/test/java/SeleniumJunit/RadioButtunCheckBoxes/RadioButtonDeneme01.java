package SeleniumJunit.RadioButtunCheckBoxes;

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

public class RadioButtonDeneme01 {
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
    public void radioButtonDeneme1() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement rb1= driver.findElement(By.xpath("//input[@type='radio'][1]"));
        WebElement rb2= driver.findElement(By.xpath("//input[@type='radio'][2]"));
        WebElement rb3= driver.findElement(By.xpath("//input[@type='radio'][3]"));
        WebElement checkbox1= driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
        WebElement checkbox2= driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        WebElement checkbox3= driver.findElement(By.xpath("//input[@id='vfb-6-2']"));


        Assert.assertFalse(rb1.isSelected());
        Assert.assertFalse(rb2.isSelected());
        Assert.assertFalse(rb3.isSelected());
        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());
        Assert.assertFalse(checkbox3.isSelected());

        rb2.click();
        Thread.sleep(2000);
        rb3.click();
        Thread.sleep(2000);

        Assert.assertFalse(rb2.isSelected());
        Assert.assertTrue(rb3.isSelected());

        checkbox1.click();
        Thread.sleep(2000);
        checkbox3.click();
        Thread.sleep(2000);

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox3.isSelected());
    }

}
