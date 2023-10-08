package LIB.UI.ANDROID;

import LIB.UI.SearchPageObject;
import io.appium.java_client.AppiumDriver;
import LIB.UI.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static{
        SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/search_container",
                SEARCH_INPUT="id:org.wikipedia:id/search_src_text",
                SEARCH_RESULT="id:org.wikipedia:id/page_list_item_title",
                SEARCH_RESULT_BY_SUBSTRING = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']",
                SEARCH_CANCEL_BUTTON="id:org.wikipedia:id/search_close_btn",
    }
    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}