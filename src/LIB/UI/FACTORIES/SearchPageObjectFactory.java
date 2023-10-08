package LIB.UI.FACTORIES;

import io.appium.java_client.AppiumDriver;
import LIB.UI.SearchPageObject;
import LIB.UI.ANDROID.AndroidSearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(AppiumDriver driver){
        return new AndroidSearchPageObject(driver);
    }
}
