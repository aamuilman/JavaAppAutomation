package TESTS;

import LIB.CoreTestCase;
import LIB.IOSCoreTestCase;
import LIB.Platform;
import LIB.UI.WelcomePageObject;
import org.junit.Test;

public class GetStarted extends CoreTestCase {
    @Test
    public void testPassWelcome(){
        if (Platform.getInstance().isAndroid()){return;}
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
