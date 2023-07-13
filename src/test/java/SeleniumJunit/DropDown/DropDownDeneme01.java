package SeleniumJunit.DropDown;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownDeneme01 {

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
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu =driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select= new Select(dropDownMenu);
        select.selectByIndex(10);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14 pro" + Keys.ENTER);
        driver.findElement(By.xpath("//span[contains(text(),'Under $25')]")).click();
        driver.findElement(By.xpath("//img[@alt='ruwa Privacy Screen Protector for iPhone 14 Pro [2-Pack][6.1 Inch] Display Tempered Glass Film with Easy Installation Fram...']")).click();

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("fcemyuksel@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();


    }
}
