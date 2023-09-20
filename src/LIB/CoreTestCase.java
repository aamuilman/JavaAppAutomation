package LIB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and83");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();

    }
    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
}
