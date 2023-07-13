package SeleniumJunit.ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass09Deneme {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

    @After
    public void tearDown(){}

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        WebElement hesabim=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(hesabim).perform();
        Thread.sleep(3000);
        //driver.findElement()
    }
}
