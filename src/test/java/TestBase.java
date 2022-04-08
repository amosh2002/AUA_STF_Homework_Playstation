import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverUtils;

public abstract class TestBase {
    @BeforeMethod
    public void startDriver() {
        DriverUtils.getDriver();
    }

    @AfterMethod
    public void quitDriver() {
        DriverUtils.quitDriver();
    }
}