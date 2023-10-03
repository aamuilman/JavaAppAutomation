package LIB.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
    private static final String
           BACK_BUTTON="xpath://*[@content-desc='Navigate up']",
            LIST_BUTTON="xpath://*[@text='View list']";
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void returnToSearchResultsFromTheArticle() {
        this.waitAndClick(
                BACK_BUTTON,
                "Cannot find button to return to the search results list",
                5
        );
    }

    public void clickByViewListButton() {
        this.waitAndClick(
                LIST_BUTTON,
                "Cannot go to View list",
                5
        );
    }
}