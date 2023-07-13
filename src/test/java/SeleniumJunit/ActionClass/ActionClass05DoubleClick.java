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

public class ActionClass05DoubleClick {
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
    public void test01() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        Actions actions =new Actions(driver);

        WebElement ele1 = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(ele1).perform();
        String expectedResult = "You have done a double click";
        String actualResult = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
        Assert.assertEquals(expectedResult,actualResult);
        System.out.println(actualResult);
        Thread.sleep(5000);


    }
}