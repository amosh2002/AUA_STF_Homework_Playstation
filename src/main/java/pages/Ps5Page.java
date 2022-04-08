package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverUtils;

public class Ps5Page extends BasePage<Ps5Page> {

    @FindBy(css = "[data-di-id='806bcb8d-913cf978']")
    private WebElement ps5Icon;

    @FindBy(css = "[data-di-id='di-id-16c59101-4efe9868']")
    private WebElement hapticFeedbackLearnMoreButton;

    @Override
    public String getUrl() {
        return BASE_URL + "ps5/";
    }

    @Override
    protected void load() {
        DriverUtils.getDriver().get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        isPs5IconDisplayed();
    }

    public boolean isPs5IconDisplayed() {
        return isElementDisplayed(ps5Icon);
    }

    public boolean isHapticFeedbackLearnMoreButtonPresent() {
        return isElementDisplayed(hapticFeedbackLearnMoreButton);
    }
}
