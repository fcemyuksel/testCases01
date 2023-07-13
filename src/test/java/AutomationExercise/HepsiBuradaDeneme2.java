package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

public class HepsiBuradaDeneme2 {
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
        //1. Tarayıcıyı açın.
        //2. https://www.hepsiburada.com adresine gidin.
        //3. Çerez tercih kısmında çerezleri kabul edin.
        //4. Arama kutusuna "iphone 14" yazın ve arayın.
        //5. Sonuçların görüntülendiğini kontrol edin.
        //6. Sol taraftaki "Ürün Çeşidi" filtresinden "iPhone 14 Plus" seçin.
        //7. Çıkan ürünlerden 2. ürünün fiyatını alın.
        //8. İkinci ürüne tıklayın.
        //9. Açılan sayfada, önceki sayfada alınan ürün fiyatıyla karşılaştırma yaparak ürünün doğruluğunu kontrol edin. Kuruşlar önemli değildir.
        //10. Ek hizmet için ekleme yapılsın.
        //11. "Sepete Ekle" düğmesine tıklayın.
        //12. Açılan Popup da "Ürün sepetinizde" ibaresinin göründüğünü kontrol edin.
        //13. "Sepete Git" düğmesine tıklayın.
        //14. Sepet ekranında olduğu kontrol edilsin.
        //15. Miktar kısmından miktarı 1 artırın.
        //16. “*Ürünlerin seçtiğin satıcılardan tedarik edilemiyor.”* ibaresi kontrol edilsin.
        //17. "Sil" düğmesine tıklayın.
        //18. "*Sepetin şu an boş*." ibaresinin göründüğünü kontrol edin.

        driver.get("https://www.hepsiburada.com/");
        String ilksayfam=driver.getWindowHandle();

        // REKLAM KISMI KAPATMA
        driver.findElement(By.xpath("//*[text()='Kabul et']")).click();
        Thread.sleep(5000);

        WebElement AramaButonu = driver.findElement(By.xpath("//div[contains(text(),'Ürün, kategori veya marka ara')]//ancestor::div[@style='justify-content:flex-start']"));
        AramaButonu.click();
        Thread.sleep(2000);

        WebElement AramaButonuAktif = driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        AramaButonuAktif.sendKeys("iphone 14"+Keys.ENTER);

        // Sonuçların görüntülendiğini kontrol edin.
        driver.findElement(By.xpath("//h1[@class='searchResultSummaryBar-AVnHBWRNB0_veFy34hco']")).isDisplayed();

        // Sol taraftaki "Ürün Çeşidi" filtresinden "iPhone 14 Plus" seçin.
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@data-test-id='not_checked'])[5]")).click();

        // Çıkan ürünlerden 2. ürünün fiyatını alın.
        WebElement ikinciÜrün=driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[13]"));
        System.out.println(ikinciÜrün.getText());
        Thread.sleep(5000);
        // İkinci ürüne tıklayın.
        driver.findElement(By.xpath("(//h3[@data-test-id='product-card-name'])[13]")).click();
        Set<String> TumPencereler=driver.getWindowHandles();
        for (String handle : TumPencereler) {
            if (!handle.equals(ilksayfam)){
                driver.switchTo().window(handle);
                break;
            }
        }
        //Açılan sayfada, önceki sayfada alınan ürün fiyatıyla karşılaştırma yaparak ürünün doğruluğunu kontrol edin. Kuruşlar önemli değildir.
        WebElement karsılastırma=driver.findElement(By.xpath("//span[text()='55.060']"));
        if (ikinciÜrün==karsılastırma){
        }
        Thread.sleep(6000);
        // Ek hizmet için ekleme yapılsın.
        scrollDownByPixel(driver,300);
        driver.findElement(By.xpath("//button[text()='Ekle']")).click();
        Thread.sleep(4000);
        // "Sepete Ekle" düğmesine tıklayın.
        driver.findElement(By.xpath("//button[@id='addToCart']")).click();
        Thread.sleep(4000);
        // Açılan Popup da "Ürün sepetinizde" ibaresinin göründüğünü kontrol edin.
        //WebElement sepetinizde=driver.findElement(By.id("Ürün sepetinizde"));
        //boolean isbuton=sepetinizde.isDisplayed();
        // "Sepete Git" düğmesine tıklayın.
        driver.findElement(By.xpath("//button[text()='Sepete git']")).click();
        Thread.sleep(40000);
        // Sepet ekranında olduğu kontrol edilsin.
        driver.findElement(By.xpath("//h1[text()='Sepetim']")).isDisplayed();
        // Miktar kısmından miktarı 1 artırın.
        driver.findElement(By.xpath("//a[@aria-label='Ürünü Arttır']")).click();
        Thread.sleep(40000);
        // “*Ürünlerin seçtiğin satıcılardan tedarik edilemiyor.”* ibaresi kontrol edilsin.
        driver.findElement(By.xpath("//div[@class='message_content_37ljR']")).isDisplayed();
        Thread.sleep(40000);
        // "Sil" düğmesine tıklayın.
        driver.findElement(By.xpath("//a[@class='delete_button_1lHhf']")).click();
        Thread.sleep(40000);
        //"*Sepetin şu an boş*." ibaresinin göründüğünü kontrol edin.
        Thread.sleep(20000);
        driver.findElement(By.id("Sepetin şu an boş")).isDisplayed();









    }

    private void scrollDownByPixel(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")");}
}




