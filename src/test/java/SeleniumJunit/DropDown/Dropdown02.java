package SeleniumJunit.DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Dropdown02 {

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
    public void test02() throws InterruptedException {

        //1- amazon.com a gidelim
        //2- drowdownmenuyu locat edelim
        //3- dropdown menu içerisinden pet supplies kategorisi seçelim.
        //4- arama kutusuna "cat bed" yazalım ve arama yapalım.
        //5- filter menu den Majestic Cat markasına tıklayalım.
        //6- up to 25$ a tıklayalım
        //7- gelen sonuç sayısının 9 olduğunu test edelim. (Assert.assertTrue((listeye atılmış elementlerin length'i)==9))
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        select.selectByIndex(20);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("cat bed"+ Keys.ENTER);
        driver.findElement(By.cssSelector("#p_36\\/2661612011 > span > a > span")).click();


    }
}