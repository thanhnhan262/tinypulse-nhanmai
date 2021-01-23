package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'Tooltip__tooltip')]")
    protected WebElement headerAction;

    @FindBy(className = "main-menu")
    protected WebElement mainMenu;

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void clickHeaderAction(String actionName) {
        String locator = ".//a[@aria-label='" + actionName + "']";
        WebElement ele = headerAction.findElement(By.xpath(locator));
        ele.click();
    }

    public void clickMenu(String menuName) {
        String locator = ".//a[.//text()='" + menuName + "']";
        WebElement ele = mainMenu.findElement(By.xpath(locator));
        ele.click();
    }
}
