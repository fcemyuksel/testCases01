package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestCase9 {

    WebDriver driver;

    @Before
    public void setup() {

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
    public void test01() throws InterruptedException {

        /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible */

        /*if (checkAnyElementIsActiveOrDisplayedXPATH("//div[@class='homepage-popup']")) {
            driver.findElement(By.xpath("//div[@class='modal-close']")).click();
*/
            driver.get("https://automationexercise.com/");
            driver.findElement(By.xpath("//*[@src='/get_product_picture/43']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[text()=' Products']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("men tshirt");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
            driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed();
            driver.findElement(By.xpath("//*[@class='product-image-wrapper']")).isDisplayed();

        }


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
