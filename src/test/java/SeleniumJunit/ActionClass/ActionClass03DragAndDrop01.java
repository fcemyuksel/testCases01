package SeleniumJunit.ActionClass;

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

public class ActionClass03DragAndDrop01 {
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
    public void test03() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");

        Actions actions = new Actions(driver);

        WebElement ele1= driver.findElement(By.xpath("//div[@class='draggable']"));
        WebElement ele2= driver.findElement(By.xpath("(//div[@class='droppable'])[1]"));
        //actions.dragAndDrop(ele1,ele2).build().perform();
        actions.clickAndHold(ele1).moveToElement(ele2).release().perform();
        Thread.sleep(3000);

        String expectedRes="Dropped!";
        String actualRes=driver.findElement(By.xpath("//div[@class='droppable']/p")).getText();
        Assert.assertEquals(expectedRes,actualRes);
        System.out.println(actualRes);


        Thread.sleep(5000);


    }
}
