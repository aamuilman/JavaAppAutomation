import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","and80");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test

    public void firstTest()
    {


       // WebElement elementToInitSearch = driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
        // elementToInitSearch.click();


        assertElementHasText(
                "//*[contains(@text,'Search Wikipedia')]",
                "Cannot find expectedText",
                "Search Wikipedia",
                5
        );
        // driver.findElementByXPath("//*[contains(@text,'Search…')]");

        // System.out.println("Firts test run f");


    }

    private WebElement waitForElementPresentByXpath(String xpath, String errorMessage, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");

        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitforElementPresentByXpath(String xpath, String errorMessage) {
        return waitForElementPresentByXpath(xpath, errorMessage,5 );
    }

    private WebElement assertElementHasText (String xpath, String errorMessage, String expectedText,long timeInSeconds )
    {
        WebElement element1 = waitForElementPresentByXpath(xpath,errorMessage,timeInSeconds);
        Assert.assertEquals(expectedText,element1.getText());
        return element1;
    }

}