package SeleniumJunit.IframeHandling;

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

public class Iframe01 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test04() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());
        Thread.sleep(2000);

        WebElement iframeElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);
        Thread.sleep(2000);

        WebElement textBox =driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        textBox.clear();
        textBox.sendKeys("Merhaba Cem Yuksel");
        Thread.sleep(2000);
        System.out.println(textBox.getText());

        driver.switchTo().defaultContent(); // defaultContent() yerine parentFrame() de kullanılır

        WebElement linkYaziElementi = driver.findElement(By.xpath("//a[normalize-space()='Elemental Selenium']"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());


    }
}
