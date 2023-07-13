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

public class CheckboxDeneme01 {

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
    public void checkboxDeneme1() throws InterruptedException {

        driver.get("https://stevefaulkner.github.io/html-mapping-tests/browser-tests/checkbox-states.html");
        WebElement checkbox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        WebElement checkbox3=driver.findElement(By.xpath("//input[@type='checkbox'][3]"));

        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());


        Thread.sleep(2000);
        checkbox1.click();

        Thread.sleep(2000);
        checkbox2.click();
        Thread.sleep(2000);
    }

}
