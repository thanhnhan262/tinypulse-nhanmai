package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "main-menu")
    protected WebElement mainMenu;

    public void clickMenu(String menuName) {
        String locator = ".//a[.//text()='" + mainMenu + "']";
        WebElement ele = mainMenu.findElement(By.xpath(locator));
        ele.click();
    }
}
