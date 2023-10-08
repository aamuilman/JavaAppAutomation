package LIB.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium. By;

public class WelcomePageObject extends MainPageObject
        private static final String
                STEP_LEARN_MORE_LINK = "Learn more about Wikipedia",
                STEP_NEW_WAYS_TO_EXPLORE_TEXT = "New ways to explore",
                STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "Add or edit preferred languages",
                STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "Learn more about data collected",
                NEXT_LINK = "Next",
                GET_STABTER_BUTTON = "Get started";
        public WelcomePageObject (AppiumDriver driver)
        {
            super(driver);
        }

public void waitForLearnMoreLink(){
    this.waitForElement(By.id (STEP_LEARN_MORE_LINK),"Cannot find Leam more about wikipedia",10)
}
        public void waitForNewWayToExploreText(){
            this.waitForElement(By.id (STEP_NEW_WAYS_TO_EXPLORE_TEXT),"Cannot find New ways to explore",10)
        }
        public void waitForAddOrEditPreferredLangText(){
            this.waitForElement(By.id (STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK),"Cannot find Add or edit preferred languages",10)
        }
        public void waitForlearnMoreAboutDataCollectedText(){
            this.waitForElement(By.id (STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK),"Cannot find Learn more about data collected",10)
        }
        public void clickNextButton(){
            this.waitForElement(By.id (NEXT_LINK),"Cannot find Next",10)
        }
        public void clickGetStarted(){
            this.waitForElement(By.id (GET_STABTER_BUTTON),"Cannot Get started",10)
        }
        public void getSkip(){
            this.waitForElement(SKIP, "cannot find skip",5);
        }