package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverUtils;

public class HomePage extends BasePage<HomePage> {

    @FindBy(id = "gdk__content")
    private WebElement whatsNewCarousel;
    @FindBy(css = "[data-di-id='di-id-7e2f5016-fa6fe93c']")
    private WebElement learnMorePs5Button;

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    @Override
    protected void load() {
        DriverUtils.getDriver().get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        isWhatsNewCarouselDisplayed();
    }

    public boolean isWhatsNewCarouselDisplayed() {
        return isElementDisplayed(whatsNewCarousel);
    }

    public Ps5Page clickLearnMorePs5Button() {
        scrollToElement(learnMorePs5Button);
        learnMorePs5Button.click();
        return new Ps5Page().init();
    }


}
