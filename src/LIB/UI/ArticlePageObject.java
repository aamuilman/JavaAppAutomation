package LIB.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{
    private static final String
            SAVE_BUTTON="id:org.wikipedia:id/page_save",
            ADD_BUTTON ="xpath://*[@text='Add to list']",
            MY_LIST_NANE_INPUT="id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            ARTICLE_TITLE ="xpath://*[@text='{TITLE}']",
            ADD_TO_ANOTHER_LIST="xpath://*[@text='Add to another reading list']",
            FOLDER_ELEMENT ="xpath://*[@text='{FOLDER_NAME}']";
    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
    /*Templates methods */
    public static String getArticleTitleXpath(String substring){
        return ARTICLE_TITLE.replace("{TITLE}",substring);


    }
    public static String getFolderXpathByName(String folder_name){
        return FOLDER_ELEMENT.replace("{FOLDER_NAME}",folder_name);


    }
    /*Templates methods */
    public WebElement waitForTitleElement(String title_text){
        String article_title_xpath = getArticleTitleXpath(title_text);
        return this.waitForElement(
                article_title_xpath,
                "Cannot find article title",
                15);
    }
    public void saveArticleToNewFolder(String name_of_folder){
        this.waitAndClick(
                SAVE_BUTTON,
                "Cannot find button to save article",
                5);
        this.waitAndClick(
                ADD_BUTTON,
                "Cannot find 'add to reading list' button",
                5);
        this.waitAndSendKeys(
                MY_LIST_NANE_INPUT,
                name_of_folder,
                "Cannot find input to set name for articles folder",
                5);
        this.waitAndClick(
               MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }
    public void saveArticleToExistingFolder(String name_of_folder){
        this.waitAndClick(
                SAVE_BUTTON,
                "Cannot find button to save article",
                5);
        this.waitAndClick(
                SAVE_BUTTON,
                "Cannot find button to save article",
                5);
        this.waitAndClick(
                ADD_TO_ANOTHER_LIST,
                "Cannot find 'Add to another reading list' option",
                5
        );
        String folder_xpath = getFolderXpathByName(name_of_folder);
        this.waitAndClick(
                folder_xpath,
                "Cannot find " +name_of_folder +" folder",
                5
        );
    }
    public void assertArticleHasTitle(String article_title){
        String article_title_xpath = getArticleTitleXpath(article_title);
        this.assertElement(
                article_title_xpath,
                "Cannot find title of the article"
        );
    }
    public void assertTitleHasText(String expected_article_title){
        String article_title_xpath = getArticleTitleXpath(expected_article_title);
        this.assertElementHasText(
                article_title_xpath,
                expected_article_title,
                "Article doesn't have title "+expected_article_title
        );
    }
}