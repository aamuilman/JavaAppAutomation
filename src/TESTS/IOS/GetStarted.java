package TESTS.IOS;

import LIB.IOSCoreTestCase;
import LIB.UI.WelcomePageObject;
import org.junit.Test;

public class GetStarted extends IOSCoreTestCase {
    @Test
    public void testPassWelcome(){
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);
        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();
        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();
        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();
        WelcomePage.waitForlearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStarted();
    }
}
