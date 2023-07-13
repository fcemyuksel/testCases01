package AutomationExercise;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DenemeNiveBaby {

    WebDriver driver;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
    }


    @Test
    public void denemeTest1() throws InterruptedException {


        driver.get("https://www.trendyol.com/");




        //if (checkAnyElementIsActiveOrDisplayedXPATH("//div[@class='homepage-popup']")) {
          //  driver.findElement(By.xpath("//div[@class='modal-close']")).click();
        //}

        // dropdown'dan bir option secmek icin 3 adim vardir
        // 1- dropdown'i locate edelim
        Thread.sleep(5000);
        WebElement dropDownMenu= driver.findElement(By.xpath("//div[@class='country-select']//Select"));

        // 2- bir Select objesi olusturup
        //    parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim
        Thread.sleep(500);
        Select select=new Select(dropDownMenu);
        // 3- Dropdown'da var olan option'lardan istedigimiz bir taneyi secelim
        Thread.sleep(500);
        select.selectByVisibleText("Turkey");
        // select.selectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Select']")).click();
        //2-
        WebElement AnneveCocuk = driver.findElement(By.xpath("//a[text()='Anne & Çocuk']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(AnneveCocuk).perform();
        Thread.sleep(5000);

        WebElement bebekButonu = driver.findElement(By.xpath("//ul[@class='sub-item-list']//a[contains(text(),'Bebek Şampuanı')]"));
        bebekButonu.click();
        Thread.sleep(5000);

        WebElement markabutonu = driver.findElement(By.xpath("//input[@placeholder='Marka ara']"));
        markabutonu.click();
        markabutonu.sendKeys("Nivea Baby");
        Thread.sleep(2000);

        WebElement niveaBabyCB = driver.findElement(By.xpath("//div[contains(text(),'Nivea Baby')]//ancestor::a[@class='fltr-item-wrppr']//div[@class='chckbox']"));
        niveaBabyCB.click();

        Thread.sleep(2000);
        WebElement fiyatbutonu = driver.findElement(By.xpath("//div[@class='fltr-cntnr-ttl'][normalize-space()='Fiyat']"));
        fiyatbutonu.click();

        Thread.sleep(2000);
        WebElement secilifiyatbutonu = driver.findElement(By.xpath("//div[contains(text(),'450 TL - 600 TL')]//ancestor::a[@class='fltr-item-wrppr']//div[@class='radio-button']"));
        secilifiyatbutonu.click();
    }

    /**
     * checkAnyElementIsActiveOrDisplayedXPATH
     * <pre>
     *         XPATH standardinda locatoru verilen herhangi bir elementin varligini,
     *         gorunurlugunu kontrol eder
     *         !!! örnek kullanım :  checkAnyElementIsActiveOrDisplayedXPATH("//input[@id='mobile_number']"); !!!
     * </pre>
     *
     * @param XPATHlocator String locator
     * @author Baris Can Ates
     */
    public boolean checkAnyElementIsActiveOrDisplayedXPATH(String XPATHlocator) throws InterruptedException {
        Thread.sleep(5000);

        List<WebElement> elementList = driver.findElements(By.xpath(XPATHlocator));
        System.out.println(elementList.size());
        if (elementList.size() > 0) {
            // Element is present
            return true;
        } else {
            // Element is not present
            return false;
        }
    }
}
