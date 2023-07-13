package SeleniumJunit.WindowHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandlinDenemeNewTab {

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
    public void test05() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("ilk sayfanın hash code'u: "+ ilkSayfaHandleDegeri);

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        WebElement ilkUrunResmi=driver.findElement(By.xpath("//img[@alt='Sponsorlu Reklam - Nutella 400 Gr Kakaolu Fındık Kreması']"));
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com.tr");

        String ikinciSayfaHandleDegeri= driver.getWindowHandle();
        System.out.println("ikinci sayfanın hash code'u: "+ ikinciSayfaHandleDegeri);

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt='Sponsorlu Reklam - Nutella 400 Gr Kakaolu Fındık Kreması']")).click();
        WebElement urunTitle =driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitle.getText());
        System.out.println("ikinci sayfanın url'i:"+ driver.getCurrentUrl());

        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println("birinci sayfanın url'i: "+driver.getCurrentUrl());
    }
}
