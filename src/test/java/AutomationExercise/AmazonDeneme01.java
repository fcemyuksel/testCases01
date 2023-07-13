package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonDeneme01 {
    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {

    }

    @Test
    public void test01() throws InterruptedException {
        //1. Tarayıcıyı açın.
        //2. [https://www.amazon.com.tr/](https://www.amazon.com.tr/cart) adresine gidin.
        //3. Çerez tercih kısmında çerezleri kabul edin.
        //4. Arama kutusuna "macbook air" yazın ve arayın.
        //5. Sonuçların görüntülendiğini kontrol edin.
        //6. Sol taraftaki "İşletim sistemi" filtresinden "Mac OS" seçin.
        //7. Çıkan ürünlerden 2. ürünün fiyatını alın.
        //8. İkinci ürüne tıklayın.
        //9. Açılan sayfada, önceki sayfada alınan ürün fiyatıyla karşılaştırma yaparak ürünün doğruluğunu kontrol edin. Kuruşlar önemli değildir.
        //10. Macbook seçeneklerinden "gümüş" rengini ve "512" kapasiteyi seçin.
        // 11. "Sepete Ekle" düğmesine tıklayın.
        //12. "Sepete Eklendi" ibaresinin göründüğünü kontrol edin.
        //13. "Sepete Git" düğmesine tıklayın.
        //14. Miktar kısmından miktarı 1 artırın.
        // 15. Miktarın arttığını kontrol edin.
        // 16. "Sil" düğmesine tıklayın.
        //17. "Amazon sepetiniz boş." ibaresinin göründüğünü kontrol edin.

        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        Thread.sleep(3000);
        //4. Arama kutusuna "macbook air" yazın ve arayın.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("macbook air"+ Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        //5. Sonuçların görüntülendiğini kontrol edin.
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Sonuçlar']")).isDisplayed();
        Thread.sleep(5000);
        //6. Sol taraftaki "İşletim sistemi" filtresinden "Mac OS" seçin.
        driver.findElement(By.xpath("//*[text()='Mac OS']")).click();
        //selector hub//li[@id='p_n_operating_system_browse-bin/12783157031']//i[@class='a-icon a-icon-checkbox']
        Thread.sleep(3000);
        //7. Çıkan ürünlerden 2. ürünün fiyatını alın.
        WebElement ikinciUrun=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]"));
        ikinciUrun.isDisplayed();
        System.out.println(ikinciUrun.getText());
        //8. İkinci ürüne tıklayın.
        Thread.sleep(3000);
       driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[2]")).click();
        //9. Açılan sayfada, önceki sayfada alınan ürün fiyatıyla karşılaştırma yaparak ürünün doğruluğunu kontrol edin. Kuruşlar önemli değildir.


    }
}