package LIB.UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {
    protected AppiumDriver driver;
    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }
        public WebElement waitForElement(By by, String error_message, long timeOutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(by));
        }

        public WebElement waitAndClick(By by, String error_message, long timeOutInSeconds) {
            WebElement element = waitForElement(by, error_message, 5);
            element.click();
            return element;

        }

        public WebElement waitAndSendKeys(By by, String keys, String error_message, long timeOutInSeconds) {
            WebElement element = waitForElement(by, error_message, 5);
            element.sendKeys(keys);
            return element;
        }

        public boolean waitForElementNotVisible(By by, String error_message, long timeOutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(by)
            );
        }

        public void swipeLeft(By by, String error_message) {
            WebElement element = waitForElement(
                    by,
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
                    .press(right_x, middle_y)
                    .waitAction(150)
                    .moveTo(left_x, middle_y)
                    .release()
                    .perform();

        }

        public void assertElementHasText(By by, String expectedText, String error_message) {
            WebElement element = waitForElement(by, "Element not found", 5);
            String actualText = element.getAttribute("value");
            Assert.assertEquals(error_message, expectedText, actualText);
        }
    public void assertElement(By by, String error_message){
        int amount_of_elements = driver.findElements(by).size();
        Assert.assertTrue(
                error_message +"\n" + "Element " + by.toString() + " supposed to be present",
                amount_of_elements==1);
    }
    public void assertElementContainsText(By by, String expected_text, String error_message) {
        WebElement element = waitForElement(by,"Element not found", 5);
        String actual_text = element.getText().toLowerCase();
        Assert.assertTrue(error_message, actual_text.contains(expected_text.toLowerCase()) );

    }
    }
