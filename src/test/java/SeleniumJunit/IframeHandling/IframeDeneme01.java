package SeleniumJunit.IframeHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeDeneme01 {

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
    public void test02() throws InterruptedException {

        driver.get("https://www.w3schools.com/howto/howto_js_element_iframe.asp");


        WebElement iframeElementi = driver.findElement(By.xpath("//*[@id=\"myFrame\"]"));
        driver.switchTo().frame(iframeElementi);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#search2"))
        .sendKeys("sql reference"+ Keys.ENTER);
        Thread.sleep(2000);

        driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_element_iframe");
        driver.findElement(By.xpath("//button[@id='runbtn']")).click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.findElement(By.xpath("//a[@title='JavaScript Tutorial']")).click();
        Thread.sleep(2000);



    }
}
