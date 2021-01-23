package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[contains(@class, 'Tooltip__tooltip')]")
    protected WebElement action;

    public void clickAction(String actionName) {
        String locator = ".//a[@aria-label='" + actionName + "']";
        WebElement ele = action.findElement(By.xpath(locator));
        ele.click();
    }
}
