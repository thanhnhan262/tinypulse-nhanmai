package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@data-cucumber='input-login-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@data-cucumber='input-login-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//div[@data-cucumber='button-continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//div[@data-cucumber='button-login']")
    WebElement btnSignIn;



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logIn(String email, String password){
        try {
            txtEmail.sendKeys(email);
            btnContinue.click();
            txtPassword.sendKeys(password);
            btnSignIn.click();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
