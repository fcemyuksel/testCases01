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

public class Deneme01 {

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

        driver.get("https://mui.com/material-ui/react-checkbox/");

        WebElement checkLabel = driver.findElement(By.xpath("//*[@id=\"demo-:R4el6kud6:\"]/div/label[1]/span[1]/input"));
        checkLabel.click();
        Thread.sleep(1000);

        WebElement checkMedium = driver.findElement(By.xpath("//*[@id=\"demo-:R5el6kud6:\"]/div/span[2]/input"));
        checkMedium.click();
        Thread.sleep(1000);

        WebElement checkRedButton = driver.findElement(By.xpath("//*[@id=\"demo-:R6el6kud6:\"]/div/span[5]/input"));
        checkRedButton.click();
        Thread.sleep(1000);

        WebElement checkKalpButton = driver.findElement(By.xpath("//*[@id=\"demo-:R7el6kud6:\"]/div/span[1]/input"));

        Assert.assertTrue(checkLabel.isEnabled());
        System.out.println("Label Butonu Iptal Edildi");
        Assert.assertTrue(checkMedium.isEnabled());
        System.out.println("Medium Butonu Iptal Edildi");
        Assert.assertTrue(checkKalpButton.isEnabled());
        System.out.println("Kalp Butonu Iptal Edildi");


    }
}