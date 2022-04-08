package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static final Duration DURATION = Duration.ofSeconds(10);

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public WaitHelper waitForElementToBeDisplayed(By location) {
        try {
            new WebDriverWait(DriverUtils.getDriver(), DURATION).
                    until(ExpectedConditions.visibilityOfElementLocated(location));
            return this;
        } catch (WebDriverException ignored) {
            throw new Error("Element with id '" + location + "' could not be found");
        }
    }

    public WaitHelper waitForElementToBeDisplayed(WebElement element) {
        try {
            new WebDriverWait(DriverUtils.getDriver(), DURATION).
                    until(ExpectedConditions.visibilityOf(element));
            return this;
        } catch (WebDriverException ignored) {
            throw new Error("Element with WebElement name '" + element + "' could not be found");
        }
    }
}
