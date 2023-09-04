import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and80");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {

        waitAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia",
                5
        );
        waitAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find text",
                5
        );
        waitForElement(
                By.id("org.wikipedia:id/page_list_item_title"),
                "No search results",
                5);

        waitAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X",
                5
        );

        waitForElementNotVisible(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Search results still",
                5

        );


    }
    private WebElement waitForElement(By by, String error_message, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitAndClick(By by, String error_message, long timeOutInSeconds) {
        WebElement element = waitForElement(by, error_message, 5);
        element.click();
        return element;

    }

    private WebElement waitAndSendKeys(By by, String keys, String error_message, long timeOutInSeconds) {
        WebElement element = waitForElement(by, error_message, 5);
        element.sendKeys(keys);
        return element;
    }

    private boolean waitForElementNotVisible(By by, String error_message, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
}