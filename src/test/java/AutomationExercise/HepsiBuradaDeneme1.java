package AutomationExercise;

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

public class HepsiBuradaDeneme1 {
    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
    }

    @Test
    public void test01() throws InterruptedException {


    // hepsiburada.com sitesine gidiniz.
    //Kategorilerden Elektronik kısmından dizüstü bilgisayara tıkla
    // Sayfada açılan çok tercih edilen windows 11 bannerına tıkla
    //marka olarak asus markasını seç
    //İlk çıkan ürüne git
    // ilk çıkan ürüne gittikten sonra ek hizmet sigortaya tıkla
    // daha sonra ürünü sepete ekle
    // sepete git sepete gittikten sonra sıklıkla birlikte alınanlardan çıkan ilk ürünü sepete ekle.

        // hepsiburada.com sitesine gidiniz.
        driver.get("https://www.hepsiburada.com/");
        Actions actions=new Actions(driver);
        WebElement elektronikButonu=driver.findElement(By.xpath("(//*[text()='Elektronik'])[1]"));
        actions.moveToElement(elektronikButonu).perform();
        Thread.sleep(5000);
        WebElement bilgisayarButonnu=driver.findElement(By.xpath("//a[text()='Bilgisayar/Tablet']"));
        actions.moveToElement(bilgisayarButonnu).perform();
        Thread.sleep(3000);
        //Kategorilerden Elektronik kısmından dizüstü bilgisayara tıkla
        driver.findElement(By.xpath("//a[text()='Dizüstü Bilgisayar']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@title='windowslu_laptoplar']")).click();
        Thread.sleep(5000);
        WebElement asusChckbox=driver.findElement(By.xpath("//input[@value='asus']"));
        Thread.sleep(5000);
        asusChckbox.click();
        Thread.sleep(15000);



    }
}