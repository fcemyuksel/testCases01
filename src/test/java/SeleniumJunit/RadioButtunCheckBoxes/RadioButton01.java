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

public class RadioButton01 {
    //TEST
    //1. https://the-internet.herokuapp.com/radiobutton web sitesine gidiniz.
    //2. rb1 , rb2 ve rb3 ü locate ediniz.
    //3. rb1 in seçili olduğunu kontrol ediniz.
    //4. rb2 nin seçili olmadığını kontrol ediniz.
    //5. rb3 nin seçili olmadığını kontrol ediniz.
    //6. rb3 e tıklayınız.
    //7. rb1 in seçili olmadığını kontrol ediniz.
    //8. rb3 ün seçili olduğunu kontrol ediniz.

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
    public void radioButtonTest() throws InterruptedException {

        driver.get("https://formy-project.herokuapp.com/radiobutton");


        WebElement rb1 = driver.findElement(By.xpath("//input[@value='option1']"));
        WebElement rb2 = driver.findElement(By.xpath("//input[@value='option2']"));
        WebElement rb3 = driver.findElement(By.xpath("//input[@value='option3']"));

        Assert.assertTrue(rb1.isSelected());
        Assert.assertFalse(rb2.isSelected());
        Assert.assertFalse(rb3.isSelected());

        Thread.sleep(2000);
        rb3.click();
        Thread.sleep(2000);

        Assert.assertFalse(rb1.isSelected());
        Assert.assertTrue(rb3.isSelected());


    }


}
