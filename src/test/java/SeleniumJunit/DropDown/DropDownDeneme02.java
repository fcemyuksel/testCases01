package SeleniumJunit.DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownDeneme02 {

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
       ;
    }

    @Test
    public void test02() throws InterruptedException {

        driver.get("https://www.amazon.com.tr/");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(dropDownMenu);
        select.selectByVisibleText("Müzik Aletleri");
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("gitar"+ Keys.ENTER);


        driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'Gitarlar, Baslar ve Ekipmanları')]")).click();

        WebElement saticiTercihi = driver.findElement(By.xpath("//span[contains(text(),'Amazon.com.tr')]"));
        saticiTercihi.click();
        driver.findElement(By.xpath("//*[@id=\"a-autoid-0\"]]")).click();
        driver.findElement(By.xpath("//img[@alt='Martin Smith 6, Akustik Gitar Süper Kit (Stand, Akort Aleti, Gitar Çantası, Kemer, Pena ve Teller dahil) - Natural']")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath("//a[@class='a-button-text']")).click();
        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
        Thread.sleep(10000);




    }
}
