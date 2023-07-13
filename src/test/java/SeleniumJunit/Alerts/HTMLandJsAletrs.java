package SeleniumJunit.Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HTMLandJsAletrs {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        /* herhangi bir web sitesine gidince veya
           bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz
           Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilanilabilir,
           bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islme yapmaya gerek yoktur
           tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
           driver.get("https://www.facebook.com"); da cikan alert vb..
           Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
           js alert'ler locate edilemez
           Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();  (bu locator da çalışıyor)
        Thread.sleep(2000);
        // alert'te OK tusuna basin
        // accept ok butonuna basmak için kullandığımız method'tur.
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // result kisminda "You successfully clicked an alert" yazdigini test edin

        String expectedResult = "You successfully clicked an alert";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText();
        System.out.println(sonucYaziElementi);
        Thread.sleep(2000);

        Assert.assertEquals(expectedResult,actualResultYazisi);
    }
}
