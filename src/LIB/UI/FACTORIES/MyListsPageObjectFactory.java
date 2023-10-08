package LIB.UI.FACTORIES;

import io.appium.java_client.AppiumDriver;
import LIB.UI.MyListsPageObject;
import LIB.UI.ANDROID.AndroidMyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListsPageObject get(AppiumDriver driver) {
        return new AndroidMyListsPageObject(driver);
    }
}