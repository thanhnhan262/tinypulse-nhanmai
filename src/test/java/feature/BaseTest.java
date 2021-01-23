package feature;

import globals.Const;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.selenium.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver webDriver;

    @Parameters("browser")
    @BeforeClass
    protected void setup(@Optional(Const.BROWSER_CHOME)String browserName) {
        webDriver = DriverFactory.getWebDriver(browserName);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Const.SHORT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS);
    }

    @AfterClass
    protected void teardown() {
//        webDriver.quit();
    }
}
