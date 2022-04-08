import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Ps5Page;

public class HomePageTest extends TestBase {

    @Test
    public static void navigateTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.init().isWhatsNewCarouselDisplayed());
        Ps5Page ps5Page = homePage.clickLearnMorePs5Button();
        Assert.assertTrue(ps5Page.isPs5IconDisplayed());
        Assert.assertTrue(ps5Page.isTextPresent("Your journey begins here."));
    }

}
