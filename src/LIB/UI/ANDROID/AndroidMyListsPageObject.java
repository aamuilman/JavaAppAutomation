package LIB.UI.ANDROID;

import io.appium.java_client.AppiumDriver;
import LIB.UI.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {
    static {
        FOLDER_BY_NAME="xpath://*[@text='{FOLDER_NAME}']",
                ARTICLE_BY_TITLE="xpath://*[@text='{ARTICLE_TITLE}']";
    }

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}