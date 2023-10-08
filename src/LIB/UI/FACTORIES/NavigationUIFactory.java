package LIB.UI.FACTORIES;

import io.appium.java_client.AppiumDriver;
import LIB.UI.NavigationUI;
import LIB.UI.ANDROID.AndroidNavigationUI;

public class NavigationUIFactory {
    public static NavigationUI get(AppiumDriver driver) {
        return new AndroidNavigationUI(driver);
    }
}