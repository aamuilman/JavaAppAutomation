package LIB.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
    private static final String
            BACK_BUTTON = "//*[@content-desc='Navigate up']",
            LIST_BUTTON = "//*[@text='View list']";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void returnToSearchResultsFromTheArticle() {
        this.waitAndClick(
                By.xpath(BACK_BUTTON),
                "Cannot find button to return to the search results list",
                5
        );
    }

    public void clickByViewListButton() {
        this.waitAndClick(
                By.xpath(LIST_BUTTON),
                "Cannot go to View list",
                5
        );
    }
}