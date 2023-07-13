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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TrendyolDeneme2 {

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

        // Trendyol TestCase
        //1."https://www.trendyol.com/" Sayfasına git.
        //2.Mouse ile "Elektronik"  kategorisinin üzerine getirelim.
        //3."Kapak & Kılıf" sekmesine tıklayalım.
        //4."Apple" kutusunu Tıklayalım.
        //5."Renk kategorinde siyahı seçelim.
        //6."Fiyat kategorisinde 0-1000 aralığını işaretleyelim.
        //7."Kargo bedava seçelim.
        //8. İkinci çıkan ürüne "SEPETE EKLE" Butonuna tıklayalım.
        //9."Sepetim" Butonuna tıklayalım.
        //10.Alttaki "Sepeti Onayla" Butonuna tıklayalım.
        //11.Eposta ve şifre girişi yapalım.

        driver.get("https://www.trendyol.com/");
        Thread.sleep(3000);
        //Ülke seçimi için Türkiye'yi seçiyoruz.
        WebElement dropDownMenu= driver.findElement(By.xpath("//div[@class='country-select']//Select"));
        Thread.sleep(3000);
        Select select=new Select(dropDownMenu);
        Thread.sleep(3000);
        select.selectByVisibleText("Turkey");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='country-actions']")).click();
        Thread.sleep(3000);
        //2.Mouse ile "Elektronik"  kategorisinin üzerine getirelim.
        WebElement Elektronik=driver.findElement(By.xpath("//a[@href='/butik/liste/5/elektronik']"));
        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(Elektronik).perform();
        Thread.sleep(3000);
        //3."Kapak & Kılıf" sekmesine tıklayalım.
        driver.findElement(By.xpath("//a[@href='/kapak-ve-kilif-x-c104026']")).click();
        Thread.sleep(3000);
        //4."Apple" kutusunu Tıklayalım.
        driver.findElement(By.xpath("//div[@class='fltrs-wrppr hide-fltrs']//div[@class='chckbox'][1]")).click();





    }
}
