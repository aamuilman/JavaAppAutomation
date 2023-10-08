package LIB.UI.FACTORIES;

import io.appium.java_client.AppiumDriver;
import LIB.UI.ArticlePageObject;
import LIB.UI.ANDROID.AndroidArticlePageObject;


public class ArticlePageObjectFactory {
    public static ArticlePageObject get(AppiumDriver driver) {
        return new AndroidArticlePageObject(driver);
    }
}