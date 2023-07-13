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

public class CheckBoxDeneme03 {

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
    public void checkboxDeneme1() throws InterruptedException {

        driver.get("https://demoqa.com/checkbox");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        checkbox.click();
        Thread.sleep(2000);
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        checkbox1.click();
        Thread.sleep(2000);
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        checkbox2.click();
        Thread.sleep(2000);
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        checkbox3.click();
        Thread.sleep(2000);
        WebElement checkbox4 = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]"));
        checkbox4.click();
        Thread.sleep(2000);

        WebElement chekNotes = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]"));
        chekNotes.click();
        Thread.sleep(2000);

        WebElement checkOffice = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label/span[1]"));
        checkOffice.click();
        Thread.sleep(2000);

        WebElement checkWord = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]"));
        checkWord.click();

        Assert.assertTrue(chekNotes.isEnabled());
        if (chekNotes.isEnabled());
        System.out.println("Notes Butonu Basilmamistir");
        Assert.assertTrue(checkOffice.isEnabled());
        if (checkOffice.isEnabled());
        System.out.println("Office Butonu Basilmamistir");
        Assert.assertTrue(checkWord.isEnabled());
        if (checkWord.isEnabled());
        System.out.println("Word Butonu Basilmamistir");

    }
}
