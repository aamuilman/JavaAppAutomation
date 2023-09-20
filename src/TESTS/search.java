package TESTS;

import LIB.CoreTestCase;
import LIB.UI.SearchPageObject;
import org.junit.Test;

import java.util.List;

public class search extends CoreTestCase {
    @Test
    public void searchResultIsNotVisible(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearch();
        searchPageObject.inputSearchLine("Java");
        searchPageObject.waitForSearchResultsVisible();
        searchPageObject.cancelSearch();
        searchPageObject.waitForSearchResultsNotVisible();
    }

}