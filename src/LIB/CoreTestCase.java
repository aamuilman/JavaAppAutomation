package LIB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;

import java.net.URL;

public class CoreTestCase extends TestCase {
    private static final String PLATFORM_IOS = "iOS"
    private static final String PLATFORM_ANDROID = "android"

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatform();

    }
    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
    private DesiredCapabilities getCapabilitiesByPlatform () throws Exception {
        String platform = System.getenv("PLATFORM")

        DesiredCapabilities capabilities = new DesiredCapabilities();
if (platform.equals(PLATFORM_ANDROID)){
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "and83");
    capabilities.setCapability("platformVersion", "8.0");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "org.wikipedia");
    capabilities.setCapability("appActivity", ".main.MainActivity");
    capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/org.wikipedia.apk");
    driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
} else if (platform.equals(PLATFORM_IOS)) {capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("deviceName", "iPhone 8");
    capabilities.setCapability("platformVersion", "16.4");
    capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/Wikipedia.app");
    driver = new IOSDriver(new URL(AppiumURL), capabilities);
} else {
throw new Exception("Cant get run"+platform)
}
return capabilities;

    }
}
