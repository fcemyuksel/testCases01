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

public class JumboaeDeneme01 {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

    @After
    public void tearDown(){driver.quit();}

    @Test
    public void test01() throws InterruptedException {

        /* 1. "https://www.jumbo.ae/" adresine gidin
              "AED 50 OFF" yazısını iptal edin.
           2. "Shop All Categories" seçeneğinden "Mobiles" sekmesinden "iPhone 14 Pro | Pro Max" seçin.
           3. Açılan sayfadan "iPhone 14 Pro Max" olduğunu görün
           4. 10. ürünü tıklayın
           4. Mor renkli ürünü seçin.
           5. Hafıza seçeneğinde 256gb seçin.
           6. "Freebies" kısmından hediyeleri kontrol et sonra açılan küçük sayfayı kapat.
           7. "Add To Cart" sekmesini tıklayın.
           8. Açılan pencerede "Go To Cart"ı tıklayın.
           9. "AppleCare+ for iPhone 14 Pro Max"i tikleyin.
           10. "Checkout" tıklayın.
           11. "eposta" ve "şifre" girin.
           12. "Login" tıklayın.
         */

        //1. "https://www.jumbo.ae/" adresine gidin
        driver.get("https://www.jumbo.ae/");
        Thread.sleep(3000);
        // "AED 50 OFF" yazısını iptal edin.
        driver.findElement(By.xpath("//*[@id=\"wps-ribbon-bottom-fix-close-button\"]")).click();
        Thread.sleep(3000);
        //2. "Shop All Categories" seçeneğinden "Mobiles" sekmesinden "iPhone 14 Pro | Pro Max" seçin.
        Actions actions=new Actions(driver);
        WebElement shopAll= driver.findElement(By.xpath("//span[@class='icon-Menu text-20px pr-3']"));
        actions.moveToElement(shopAll).perform();
        Thread.sleep(3000);
        WebElement mobiles=driver.findElement(By.xpath("//a[@title='Mobiles']"));
        actions.moveToElement(mobiles).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='iPhone 14 Pro | Pro Max']")).click();
        Thread.sleep(3000);
        //3. Açılan sayfadan "iPhone 14 Pro Max" olduğunu görün
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='iPhone 14 Pro Max']"))
                .isDisplayed());
        Thread.sleep(3000);
        //4. 10. ürünü tıklayın
        driver.findElement(By.xpath("//a[@href='/apple-iphone-14-pro-5g-smartphone-10094435.html']")).click();
        Thread.sleep(3000);
        //Mor renkli ürünü seçin.
        driver.findElement(By.xpath("//img[@alt='Purple']")).click();
        Thread.sleep(3000);
        //Hafıza seçeneğinde 256gb seçin.
        driver.findElement(By.xpath("(//*[@class='rounded-xl p-2 border'])[1]")).click();
        Thread.sleep(3000);
        //"Freebies" kısmından hediyeleri kontrol et sonra açılan küçük sayfayı kapat.
        driver.findElement(By.xpath("//button[@class='text-xs whitespace-nowrap text-blue-dark pl-10']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='icon-Close text-xl cursor-pointer']")).click();
        Thread.sleep(3000);
        //"Add To Cart" sekmesini tıklayın
        driver.findElement(By.xpath("(//div[@class='md:mr-0 w-full mr-5px'])[1]")).click();
        Thread.sleep(3000);
        //Açılan pencerede "Go To Cart"ı tıklayın.
        driver.findElement(By.xpath("//span[@class='py-6 inline-block']")).click();
        Thread.sleep(3000);
        //WebElement chckBox=driver.findElement(By.xpath("//input[@value='SFYW2AE/A']"));
        //chckBox.click();
        driver.findElement(By.xpath("(//button[@class='button full-button w-full cursor-pointer space-x-0 primary primary-full px-1'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cyuksel@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
