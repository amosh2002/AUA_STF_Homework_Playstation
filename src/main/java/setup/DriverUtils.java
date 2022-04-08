package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverUtils {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.playstation.com/en-us/");
        }
        return driver;
    }

    public static void quitDriver() {
        getDriver().quit();
        driver = null;
    }
}
