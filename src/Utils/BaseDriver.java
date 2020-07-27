package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import java.util.Random;

public class BaseDriver {
    protected WebDriver driver;
    protected Actions builder;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Waiter waiters;
    protected SoftAssert softAssert;
    protected Random rnd;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    protected void setup(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty( "webdriver.chrome.driver", "D:\\Selenium dependency\\DreiverZ\\chromedriver.exe" );
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equals("edge")) {
            System.setProperty( "webdriver.edge.driver", "D:\\Selenium dependency\\DreiverZ\\msedgedriver.exe" );
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, 15);
        js = (JavascriptExecutor) driver;
        waiters = new Waiter( wait,driver );
        softAssert = new SoftAssert();
        rnd = new Random();
    }

    @AfterClass(alwaysRun = true)
    protected void closeDriver() {
        driver.quit();
    }
}
