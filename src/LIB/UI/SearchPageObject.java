package LIB.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/search_container",
            SEARCH_INPUT="id:org.wikipedia:id/search_src_text",
            SEARCH_RESULT="id:org.wikipedia:id/page_list_item_title",
            SEARCH_RESULT_BY_SUBSTRING = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']",
            SEARCH_CANCEL_BUTTON="id:org.wikipedia:id/search_close_btn",
    public SearchPageObject(AppiumDriver driver){
        super(driver);
    }
    /*Templates methods */
    public static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING.replace("{SUBSTRING}",substring);


    }
    /*Templates methods */
    public void initSearch(){
        this.waitForElement(
                SEARCH_INIT_ELEMENT,
                "element to init search is not present",
                5);
        this.waitAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find and click seach init element",
                5
        );
    }
    public void inputSearchLine(String searchLine){
        this.waitForElement(
                SEARCH_INPUT,
                "element to input search line is not present",
                5);
        this.waitAndSendKeys(
                SEARCH_INPUT,
                searchLine,
                "Cannot find search input and send keys",
                5
        );

    }
    public void waitForSearchResultsVisible(){
        this.waitForElement(
                SEARCH_RESULT,
                "No search results found",
                5
        );
    }
    public void waitForSearchResultsNotVisible(){
        this.waitForElementNotVisible(
                SEARCH_RESULT,
                "Search results are still present",
                5
        );
    }

    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitAndClick(
                search_result_xpath,
                "Cannot find and click search result with substring " + substring,
                10
        );
    }
    public void cancelSearch(){
        this.waitAndClick(
                SEARCH_CANCEL_BUTTON,
                "Cannot find and click cancel button",
                5
        );
    }
    public void assertEveryResultContainsSearchString(String search_line){
        this.assertElementContainsText(SEARCH_RESULT),
                search_line,
                "Search result title does not contain text "+search_line );

    }
    public void assertInputElementHasText(String expected_text){
        this.assertElementHasText(By.xpath("xpath://*[contains(@text, 'Search Wikipedia')]", expected_text,
                "Field for text input does not have text" + expected_text);
    }
}
