package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Trendyoldeneme01 {
    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {driver.quit();    }

    @Test
    public void test01() throws InterruptedException {

        // Trendyol TestCase
        //1."https://www.trendyol.com/" Sayfasına git.
        //2.Mouse mizi "Erkek"  Katagorisinin üzerine getirelim.
        //3."Tişört" sekmesine tıklayalım.
        //4."Çıkan ilk ürüne" Tıklayalım.
        //5."Black Sokak Erkek Gri Göğüs Ince Çizgili" Yazısının görünür olduğunu bulalım.
        //6."Renk seçeneklerinin üzerinde" mousemizi gezdirelim.
        //7."Beden" sekmesinden L bedeni seçelim.
        //8."SEPETE EKLE" Butonuna tıklayalım.
        //9."Sepetim" Butonuna tıklayalım.
        //10.Alttaki "Sepeti Onayla" Butonuna tıklayalım.

        driver.get("https://www.trendyol.com/");

      /*  if (checkAnyElementIsActiveOrDisplayedXPATH("//div[@class='homepage-popup']")) {
            driver.findElement(By.xpath("//div[@class='modal-close']")).click();
        }*/

        Thread.sleep(5000);
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[@class='country-select']//Select"));

        Thread.sleep(500);
        Select select = new Select(dropDownMenu);

        Thread.sleep(500);
        select.selectByVisibleText("Turkey");
        driver.findElement(By.xpath("//*[@class=\"country-actions\"]")).click();

        WebElement Erkek = driver.findElement(By.xpath("//a[text()='Erkek']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Erkek).perform();
        Thread.sleep(5000);
        // driver.findElement(By.xpath("//li[@class='tab-link']//a[text()='Erkek']")).isDisplayed();
        // Thread.sleep(15000);
        driver.findElement(By.xpath("//div[@id='sub-nav-2']//a[contains(text(),'Tişört')]")).click();
        Thread.sleep(5000);
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='p-card-chldrn-cntnr card-border']"));
        elementList.get(0).click();
        Thread.sleep(3000);
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        Thread.sleep(3000);
        String istenenKelime = "trendyol";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("gercek Url:" + actualUrl);
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.trendyol.com/black-sokak/erkek-gri-gogus-ince-cizgili-paris-baskili-oversize-bisiklet-yaka-tisort-p-311079654");
        Thread.sleep(5000);

        List<WebElement> renkler= (List<WebElement>) driver.findElement(By.xpath("//div[@class='slicing-attributes']//a"));
        for (int i = 0; i < renkler.size(); i++) {
        actions.moveToElement(renkler.get(i)).perform();
        }

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='L']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Sepetim']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='ty-link-btn-primary']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys("cyuksel@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='login-password-input']")).sendKeys("123456");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Giriş Yap')]")).click();
        Thread.sleep(3000);

    }


}
