package SeleniumJunit.ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass07MouseHover02 {
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
    public void test07() throws InterruptedException {
        driver.get("https://www.trendyol.com/");
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//div[@id='gender-popup-app']//div[@class='modal-close']")).click();

        WebElement elektronikBaslik = driver.findElement(By.xpath("//a[@href='/butik/liste/5/elektronik']"));
        actions.moveToElement(elektronikBaslik).perform();
        WebElement laptopBaslik = driver.findElement(By.xpath("//div[@id='sub-nav-5']//a[contains(text(),'Laptop')]"));
        actions.moveToElement(laptopBaslik).perform();
        Thread.sleep(2000);


        WebElement appleGold = driver.findElement(By.xpath("//span[@title=\"Macbook Air 13'' M1 8gb 256gb Ssd Altın\"]"));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.trendyol.com/apple/macbook-air-mgnd3tu-a-m1-8gb-256gb-ssd-retina-13-3inc-gold-p-410963851");
        WebElement ekGaranti = driver.findElement(By.xpath("//div[@class='styles-module_item-tracker__3bypy']//div[1]//div[1]//span[1]//span[1]//span[2]"));
        ekGaranti.click();
        WebElement onarimPaketi = driver.findElement(By.xpath("//span[@class='i-vas-default-checkbox']//span[@class='path2']"));
        onarimPaketi.click();



    }
}
