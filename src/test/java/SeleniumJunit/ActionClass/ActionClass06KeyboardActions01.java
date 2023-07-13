package SeleniumJunit.ActionClass;

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
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

public class ActionClass06KeyboardActions01 {
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
    public void test06() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        WebElement searchAction = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.click(searchBar).keyDown(Keys.SHIFT)
                .sendKeys("selen")
                .keyUp(Keys.SHIFT)
                .sendKeys("yum")
                .perform();
        actions.click(searchAction).perform();
        String expectedRes = "selenium";
        String actualRes = driver.findElement(By.xpath("//span[@class='a-size-medium a-text-italic']")).getText();
        Assert.assertEquals(expectedRes, actualRes);
        System.out.println(actualRes);


        Thread.sleep(5000);


    }
}
