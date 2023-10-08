package LIB.UI.ANDROID;

import io.appium.java_client.AppiumDriver;
import LIB.UI.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        SAVE_BUTTON="id:org.wikipedia:id/page_save",
                ADD_BUTTON ="xpath://*[@text='Add to list']",
                MY_LIST_NANE_INPUT="id:org.wikipedia:id/text_input",
                MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
                ARTICLE_TITLE ="xpath://*[@text='{TITLE}']",
                ADD_TO_ANOTHER_LIST="xpath://*[@text='Add to another reading list']",
                FOLDER_ELEMENT ="xpath://*[@text='{FOLDER_NAME}']";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}