import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobject.HomePage;

public class BaseTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test() {

        driver.get("https://www.newegg.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        HomePage homePage = new HomePage(driver);
        int count = homePage.search("oculus").getAddToCardButtonsCount();

        Assert.assertEquals(count, 24);

    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

}
