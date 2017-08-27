package helpers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by pc on 27.08.2017.
 */
public class BaseTest {
    protected static WebDriver chrome;

    @BeforeClass
    public static void setup() {
        ChromeDriverManager.getInstance().setup();

    }

    @BeforeMethod
    public static void setupDriver() {
        chrome = new ChromeDriver();
        chrome.manage().window().setPosition(new Point(1920, 24));
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @AfterClass
    public static void teardown() {
        if (chrome != null) {
            chrome.quit();
        }
    }

    /*public static pages.WelcomePage login(){
        chrome.get("https://my-sandbox.maxpay.com/#/signin");
        pages.LoginPage loginPage = new pages.LoginPage(chrome);
        return new pages.WelcomePage(chrome);
    }*/
}
