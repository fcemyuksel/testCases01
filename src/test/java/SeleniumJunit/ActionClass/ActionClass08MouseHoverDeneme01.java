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

public class ActionClass08MouseHoverDeneme01 {

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
    public void test08() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        Actions actions=new Actions(driver);
        WebElement elektronikBasligi=driver.findElement(By.xpath("//span[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC']//span[contains(text(),'Elektronik')]"));
        actions.moveToElement(elektronikBasligi).perform();
        WebElement bilgisayarAltBasligi=driver.findElement(By.xpath("//a[normalize-space()='Bilgisayar/Tablet']"));
        actions.moveToElement(bilgisayarAltBasligi).perform();
        WebElement ssd= driver.findElement(By.xpath("//span[normalize-space()='SSD,']"));
        actions.click(ssd);
        Thread.sleep(2000);


    }
}
