package TESTS;

import LIB.CoreTestCase;
import LIB.UI.ArticlePageObject;
import LIB.UI.SearchPageObject;
import org.junit.Test;

public class article extends CoreTestCase {
    @Test

    public void ArticleHasTitle(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearch();
        String article_search = "Java";
        searchPageObject.inputSearchLine(article_search);
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        String title_of_the_article="Java (programming language)";
        articlePageObject.assertArticleHasTitle(title_of_the_article);
    }
}