package SeleniumJunit.RadioButtunCheckBoxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButtonDeneme02 {

    //TEST CASE RADİOBUTTON ORNEKLERİ
    //1) Siteye gidin https://demoqa.com/radio-button
    //2) Sayfayı tam sayfa olarak ayarlayın
    //3) Sayfada 15 saniye bekleyin.
    //4) Yes radiobutton xpath alın.
    //5) Yes radiobutton tıklayın
    //6) Testiniz başarıyla sonlandırılmıştır yazdırın.

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

        driver.get("https://demoqa.com/radio-button");
        WebElement yesradioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesradioButton.isEnabled();
        Thread.sleep(2000);
        WebElement impressiveRadioButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveRadioButton.isEnabled();
        impressiveRadioButton.click();
        Thread.sleep(2000);

        if (yesradioButton.isEnabled());
        yesradioButton.click();
        System.out.println("testiniz başarıyla sonlandırılmıştır.");

    }
}
