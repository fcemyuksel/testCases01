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
import java.util.Set;

public class DenemeDers3 {

    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After

    public void tearDown() {  driver.quit();   }

    @Test

    public void test01() throws InterruptedException {

        driver.get("https://www.trendyol.com/");
        driver.findElement(By.xpath("//div[@class='country-select']")).click();
        driver.findElement(By.xpath("//option[text()='Turkey']")).click();
        driver.findElement(By.xpath("//button[text()='Select']/parent::div")).click();
        //alıcı  Herkes
        //1=trendyol git.

        String ilksayfam = driver.getWindowHandle(); // ilk sayfayı tanıttık.


        // REKLAM KISMI KAPATMA
        //driver.findElement(By.xpath("//button[text()='KABUL ET']")).click();
        Thread.sleep(1000);
        //1=trendyol kadın bölümünden kadına tıkla
        WebElement KadinButonu = driver.findElement(By.xpath("//a[text()='Kadın']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(KadinButonu).perform();

        WebElement GiyimButonu = driver.findElement(By.xpath("//div[@id='sub-nav-1']//a[@class='sub-category-header'][normalize-space()='Giyim']"));
        GiyimButonu.click();
        Thread.sleep(3000);
        //2=marka sekmentinden trendyolmilla tıkla
        driver.findElement(By.xpath("//div[text()='TRENDYOLMİLLA']/parent::a//div[@class='chckbox']")).click();
        Thread.sleep(3000);
        //3=beden kategorisinde  s bedene tıkla
        driver.findElement(By.xpath("//div[text()='S']/parent::a//div[@class='chckbox']")).click();
        Thread.sleep(3000);
        //4=ürün değerlendirilmesinden fotograflı yorumlara tıkla
        driver.findElement(By.xpath("//div[text()='Fotoğraflı Yorumlar']/parent::a//div[@class='chckbox']")).click();
        Thread.sleep(4000);
        //5= önerileren sıralamarda önerilen sıralama tıkla.
        driver.findElement(By.xpath("//option[text()='Önerilen sıralama']")).click();
        Thread.sleep(3000);
        //en düşük fiyatlı kategoriyi seç.
        driver.findElement(By.xpath("//option[text()='En düşük fiyat']")).click();
        Thread.sleep(4000);
        // çıkan ilk ürüne tıkla
        driver.findElement(By.xpath("//div[@data-id='226071014']//div[@class='p-card-chldrn-cntnr card-border']")).click();
        Thread.sleep(4000);
        Set<String> TumPencereler = driver.getWindowHandles();
        for (String handle : TumPencereler) {
            if (!handle.equals(ilksayfam)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(3000);
        //7= sepete ekle
        driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();
        Thread.sleep(3000);
        //8=sepete ekledikten sonra sepete git.
        driver.findElement(By.xpath("//i[@class='i-bagg-orange hover-icon']")).click();
        Thread.sleep(3000);
        //9= sepete gittikten sonra sepeti onayla
        driver.findElement(By.xpath("(//a[@class='ty-link-btn-primary'])[1]")).click();
        driver.close();
        System.out.println("Test tamamlanmıştır");
        WebDriver driver;



    }
}

