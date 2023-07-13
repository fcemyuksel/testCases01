package SeleniumJunit.ActionClass;

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

public class ActionClass02ContexClick {

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
        //1- web sitesine git
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        //2- sag tik alanını locate et.
        WebElement sagTikAlani = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(sagTikAlani).perform();

        //4- alert mesajının "You selected a context menu" oldugunu kontrol et.

        String expectedText="You selected a context menu";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);

        driver.switchTo().alert().accept();

        Thread.sleep(5000);
    }
}
