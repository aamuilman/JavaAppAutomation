package LIB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSCoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "16.4");
        capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/Wikipedia.app");
        driver = new IOSDriver(new URL(AppiumURL), capabilities);
    }
    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
}
