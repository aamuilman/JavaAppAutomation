package TESTS;

import LIB.CoreTestCase;
import LIB.UI.FACTORIES.SearchPageObjectFactory;
import LIB.UI.SearchPageObject;
import org.junit.Test;

import java.util.List;

public class search extends CoreTestCase {
    @Test
    public void searchResultIsNotVisible(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearch();
        searchPageObject.inputSearchLine("Java");
        searchPageObject.waitForSearchResultsVisible();
        searchPageObject.cancelSearch();
        searchPageObject.waitForSearchResultsNotVisible();
    }

}