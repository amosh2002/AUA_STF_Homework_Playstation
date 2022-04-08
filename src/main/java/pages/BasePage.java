package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.WaitHelper;

import static setup.DriverUtils.getDriver;


public abstract class BasePage<T> extends LoadableComponent<BasePage<T>> {
    protected WebDriver driver;
    protected Actions actions;
    public static final String BASE_URL = "https://www.playstation.com/en-us/";

    public BasePage() {
        this.driver = getDriver();
        actions = new Actions(driver);
    }

    public abstract String getUrl();

    public final void open() {
        driver.get(getUrl());
    }

    public T init() {
        PageFactory.initElements(getDriver(), this);
        return (T) this;
    }

    public WebElement findElement(By location) {
        WaitHelper.getInstance().waitForElementToBeDisplayed(location);
        return driver.findElement(location);
    }

    public boolean isElementDisplayed(By location) {
        return findElement(location).isDisplayed();
    }

    public boolean isElementDisplayed(WebElement element) {
        WaitHelper.getInstance().waitForElementToBeDisplayed(element);
        return element.isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        actions
                .moveToElement(element)
                .perform();
    }

    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }
}
