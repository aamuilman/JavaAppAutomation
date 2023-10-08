import LIB.CoreTestCase;
import LIB.UI.ArticlePageObject;
import LIB.UI.MyListsPageObject;
import LIB.UI.NavigationUI;
import LIB.UI.SearchPageObject;
import org.junit.Test;

public class list extends CoreTestCase {
    @Test
    public void SaveTwo_DeleteOne(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearch();
        String article_search = "Java";
        searchPageObject.inputSearchLine(article_search);
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement("Java (programming language)");
        String name_of_folder="Learning programming";
        articlePageObject.saveArticleToNewFolder(name_of_folder);
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.returnToSearchResultsFromTheArticle();
        searchPageObject.clickByArticleWithSubstring("High-level programming language");
        articlePageObject.waitForTitleElement("JavaScript");
        articlePageObject.saveArticleToExistingFolder(name_of_folder);
        navigationUI.clickByViewListButton();
        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        myListsPageObject.openFolder(name_of_folder);
        myListsPageObject.swipeToDelete("Java (programming language)");
        myListsPageObject.SavedArticleAndClick("High-level programming language");
        articlePageObject.assertTitleHasText("JavaScript");

    }


}