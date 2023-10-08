package LIB;

import LIB.UI.ANDROID.AndroidSearchPageObject;
import LIB.UI.WelcomePageObject;
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
        driver = Platform.getInstance().isAndroid(){
            return new AndroidSearchPageObject(driver);
        } else {
            return new iOSSearchPageObject(driver);
        };
       this.skipWelcomePageObject();

    }
    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
    private void skipWelcomePageObject(){
if(Platform.getInstance().isIOS()){
    WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
    WelcomePageObject.clickSkip();
}
    }
}
