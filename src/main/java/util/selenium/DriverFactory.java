package util.selenium;

import globals.Const;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getWebDriver(String browserName) {
        WebDriver webDriver;
        switch (browserName){
            case Const.BROWSER_CHOME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case Const.BROWSER_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new WebDriverManagerException("Browser is not supported: " + browserName);
        }
        return webDriver;
    }
}
