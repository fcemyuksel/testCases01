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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Deneme4Amazonae {

    WebDriver driver;

    @Before

    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){driver.quit();}

    @Test

    public void test01() throws InterruptedException {

        //1. amazon.ae git
        driver.get("https://www.amazon.ae/");
        //2. dropdown menü locatörü al
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        //3.video games kategorisi seç
        select.selectByVisibleText("Video Games");
        Thread.sleep(3000);
        //4. seçilen kategoride "ps vita" arattır
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("ps vita"+ Keys.ENTER);
        Thread.sleep(3000);
        //5.shipped from uae seç
        driver.findElement(By.xpath("//li[@id='p_n_prime_domestic/20642115031']")).click();
        Thread.sleep(3000);
        //6. get it by tomorrow
    }

}
