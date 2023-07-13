package SeleniumJunit.WindowHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandlinDenemeNewWindow {

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
    public void test06(){

        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        String isteneKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Gercek Url:" + actualUrl);
        Assert.assertTrue(actualUrl.contains(isteneKelime));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.trendyol.com/");
        String ikinciSayfaninHandleDegeri = driver.getWindowHandle();
        String istenenKelime2 = "trendyol";
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        String sonucYazisiStr=sonucYaziElementi.getText();
        String aradigimizKelime="nutella";
        System.out.println("sonuc elementi"+ sonucYaziElementi.getText());
        System.out.println("sonuc yazisi"+ sonucYazisiStr);
        Assert.assertTrue(sonucYazisiStr.contains(aradigimizKelime));





    }
}
