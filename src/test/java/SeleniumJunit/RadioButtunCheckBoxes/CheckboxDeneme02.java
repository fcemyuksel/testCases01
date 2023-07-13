package SeleniumJunit.RadioButtunCheckBoxes;

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

public class CheckboxDeneme02 {

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
        driver.close();
    }

    @Test
    public void checkboxDeneme2() throws InterruptedException {
        driver.get("https://faculty.washington.edu/chudler/java/boxes.html");
        WebElement checkbox1= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        WebElement checkbox3= driver.findElement(By.xpath("//input[@type='checkbox'][3]"));
        WebElement checkbox4= driver.findElement(By.xpath("//input[@type='checkbox'][4]"));
        WebElement checkbox5= driver.findElement(By.xpath("//input[@type='checkbox'][5]"));
        WebElement checkbox6= driver.findElement(By.xpath("//input[@type='checkbox'][6]"));
        WebElement checkbox7= driver.findElement(By.xpath("//input[@type='checkbox'][7]"));
        WebElement checkbox8= driver.findElement(By.xpath("//input[@type='checkbox'][8]"));
        WebElement checkbox9= driver.findElement(By.xpath("//input[@type='checkbox'][9]"));
        WebElement checkbox10= driver.findElement(By.xpath("//input[@type='checkbox'][10]"));
        WebElement checkbox21= driver.findElement(By.xpath("//input[@type='checkbox'][21]"));
        WebElement checkbox22= driver.findElement(By.xpath("//input[@type='checkbox'][22]"));
        WebElement checkbox23= driver.findElement(By.xpath("//input[@type='checkbox'][23]"));
        WebElement checkbox24= driver.findElement(By.xpath("//input[@type='checkbox'][24]"));
        WebElement checkbox25= driver.findElement(By.xpath("//input[@type='checkbox'][25]"));
        WebElement checkbox26= driver.findElement(By.xpath("//input[@type='checkbox'][26]"));
        WebElement checkbox27= driver.findElement(By.xpath("//input[@type='checkbox'][27]"));
        WebElement checkbox28= driver.findElement(By.xpath("//input[@type='checkbox'][28]"));
        WebElement checkbox29= driver.findElement(By.xpath("//input[@type='checkbox'][29]"));
        WebElement checkbox30= driver.findElement(By.xpath("//input[@type='checkbox'][30]"));
        WebElement checkbox41= driver.findElement(By.xpath("//input[@type='checkbox'][41]"));
        WebElement checkbox42= driver.findElement(By.xpath("//input[@type='checkbox'][42]"));
        WebElement checkbox43= driver.findElement(By.xpath("//input[@type='checkbox'][43]"));
        WebElement checkbox44= driver.findElement(By.xpath("//input[@type='checkbox'][44]"));
        WebElement checkbox45= driver.findElement(By.xpath("//input[@type='checkbox'][45]"));
        WebElement checkbox46= driver.findElement(By.xpath("//input[@type='checkbox'][46]"));
        WebElement checkbox47= driver.findElement(By.xpath("//input[@type='checkbox'][47]"));
        WebElement checkbox48= driver.findElement(By.xpath("//input[@type='checkbox'][48]"));
        WebElement checkbox49= driver.findElement(By.xpath("//input[@type='checkbox'][49]"));
        WebElement checkbox50= driver.findElement(By.xpath("//input[@type='checkbox'][50]"));
        WebElement checkbox61= driver.findElement(By.xpath("//input[@type='checkbox'][61]"));
        WebElement checkbox62= driver.findElement(By.xpath("//input[@type='checkbox'][62]"));
        WebElement checkbox63= driver.findElement(By.xpath("//input[@type='checkbox'][63]"));
        WebElement checkbox64= driver.findElement(By.xpath("//input[@type='checkbox'][64]"));
        WebElement checkbox65= driver.findElement(By.xpath("//input[@type='checkbox'][65]"));
        WebElement checkbox66= driver.findElement(By.xpath("//input[@type='checkbox'][66]"));
        WebElement checkbox67= driver.findElement(By.xpath("//input[@type='checkbox'][67]"));
        WebElement checkbox68= driver.findElement(By.xpath("//input[@type='checkbox'][68]"));
        WebElement checkbox69= driver.findElement(By.xpath("//input[@type='checkbox'][69]"));
        WebElement checkbox70= driver.findElement(By.xpath("//input[@type='checkbox'][70]"));







        checkbox1.click();
        checkbox2.click();
        checkbox3.click();
        checkbox4.click();
        checkbox5.click();
        checkbox6.click();
        checkbox7.click();
        checkbox8.click();
        checkbox9.click();
        checkbox10.click();
        checkbox21.click();
        checkbox22.click();
        checkbox23.click();
        checkbox24.click();
        checkbox25.click();
        checkbox26.click();
        checkbox27.click();
        checkbox28.click();
        checkbox29.click();
        checkbox30.click();
        checkbox41.click();
        checkbox42.click();
        checkbox43.click();
        checkbox44.click();
        checkbox45.click();
        checkbox46.click();
        checkbox47.click();
        checkbox48.click();
        checkbox49.click();
        checkbox50.click();
        checkbox61.click();
        checkbox62.click();
        checkbox63.click();
        checkbox64.click();
        checkbox65.click();
        checkbox66.click();
        checkbox67.click();
        checkbox68.click();
        checkbox69.click();
        checkbox70.click();
        checkbox1.click();
        checkbox2.click();
        checkbox3.click();
        checkbox4.click();
        checkbox5.click();
        checkbox6.click();
        checkbox7.click();
        checkbox8.click();
        checkbox9.click();
        checkbox10.click();
        checkbox21.click();
        checkbox22.click();
        checkbox23.click();
        checkbox24.click();
        checkbox25.click();
        checkbox26.click();
        checkbox27.click();
        checkbox28.click();
        checkbox29.click();
        checkbox30.click();
        checkbox41.click();
        checkbox42.click();
        checkbox43.click();
        checkbox44.click();
        checkbox45.click();
        checkbox46.click();
        checkbox47.click();
        checkbox48.click();
        checkbox49.click();
        checkbox50.click();
        checkbox61.click();
        checkbox62.click();
        checkbox63.click();
        checkbox64.click();
        checkbox65.click();
        checkbox66.click();
        checkbox67.click();
        checkbox68.click();
        checkbox69.click();
        checkbox70.click();
        checkbox1.click();
        checkbox2.click();
        checkbox3.click();
        checkbox4.click();
        checkbox5.click();
        checkbox6.click();
        checkbox7.click();
        checkbox8.click();
        checkbox9.click();
        checkbox10.click();
        checkbox21.click();
        checkbox22.click();
        checkbox23.click();
        checkbox24.click();
        checkbox25.click();
        checkbox26.click();
        checkbox27.click();
        checkbox28.click();
        checkbox29.click();
        checkbox30.click();
        checkbox41.click();
        checkbox42.click();
        checkbox43.click();
        checkbox44.click();
        checkbox45.click();
        checkbox46.click();
        checkbox47.click();
        checkbox48.click();
        checkbox49.click();
        checkbox50.click();
        checkbox61.click();
        checkbox62.click();
        checkbox63.click();
        checkbox64.click();
        checkbox65.click();
        checkbox66.click();
        checkbox67.click();
        checkbox68.click();
        checkbox69.click();





    }
}
