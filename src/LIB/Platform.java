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

public class Platform {
    private static final String PLATFORM_IOS = "iOS"
    private static final String PLATFORM_ANDROID = "android"
    private static final String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    private static Platform instance;
    private Platform(){

    }
    public static Platform getInstance(){
        if (instance==null){
            instance = new Platform()
        }
        return instance;
    }
    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and83");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/org.wikipedia.apk");
        return capabilities;
    }
    private DesiredCapabilities getIOSDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "16.4");
        capabilities.setCapability("app", "/Volumes/KINGSTON/JavaAppiumAutomation/JavaAppAutomation/apks/Wikipedia.app");
    }
    private DesiredCapabilities getCapabilitiesByPlatform () throws Exception {
        String platform = System.getenv("PLATFORM")
    }

    private String getPlatformVar(){
        return System.getenv("PLATFORM");
    }
    private boolean isPlatform(String my_platform){
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public boolean isAndroid(){
        return  isPlatform(PLATFORM_ANDROID);
    }
    public boolean isIOS(){
        return  isPlatform(PLATFORM_IOS);
    }
    public AppiumDriver getDriver() throws Exception{
        URL URL = new URL(AppiumURL);
        if(this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        }else if (this.isIOS()){
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());}
        else {
            throw new Exception("Cannot detect type of the driver . Platform value: "+ this.getPlatformVar());
        }
    }
}

