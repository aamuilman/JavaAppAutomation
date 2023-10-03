package LIB.UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import java.util.regex.Pattern;

public class MainPageObject {
    protected AppiumDriver driver;
    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }
        public WebElement waitForElement (String locator, String error_message, long timeOutInSeconds) {
            By by = this.getLocatorByString(locator);
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(by));
        }

        public WebElement waitAndClick(String locator, String error_message, long timeOutInSeconds) {
            WebElement element = waitForElement(locator, error_message, 5);
            element.click();
            return element;

        }

        public WebElement waitAndSendKeys(String locator, String keys, String error_message, long timeOutInSeconds) {
            WebElement element = waitForElement(locator, error_message, 5);
            element.sendKeys(keys);
            return element;
        }

        public boolean waitForElementNotVisible(String locator, String error_message, long timeOutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(locator)
            );
        }

        public void swipeLeft(String locator, String error_message) {
            WebElement element = waitForElement(
                    locator,
                    error_message,
                    5
            );
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int lower_y = element.getLocation().getY();
            int upper_y = lower_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;
            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(right_x,middle_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                    .moveTo(PointOption.point(left_x,middle_y))
                    .release()
                    .perform();

        }

        public void assertElementHasText(String locator, String expectedText, String error_message) {
            WebElement element = waitForElement(locator, "Element not found", 5);
            String actualText = element.getAttribute("value");
            Assert.assertEquals(error_message, expectedText, actualText);
        }
    public void assertElement(String locator, String error_message){
        int amount_of_elements = driver.findElements(locator).size();
        Assert.assertTrue(
                error_message +"\n" + "Element " + locator.toString() + " supposed to be present",
                amount_of_elements==1);
    }
    public void assertElementContainsText(String locator, String expected_text, String error_message) {
        WebElement element = waitForElement(locator,"Element not found", 5);
        String actual_text = element.getText().toLowerCase();
        Assert.assertTrue(error_message, actual_text.contains(expected_text.toLowerCase()) );

    }
    private By getLocatorByString(String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];
        if (by_type.equals("xpath")){
            return By.xpath(locator);
        }
        if (by_type.equals("id")){
            return By.id(locator);
        }
        else throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locator_with_type);
    }

    }
