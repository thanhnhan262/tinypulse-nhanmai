package feature.UserSettings;

import feature.BaseTest;
import globals.Const;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.AddPeoplePage;
import pageobject.LoginPage;

import java.util.HashMap;
import java.util.Map;

public class ManageUserTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        webDriver.get(Const.URL);
    }

    @Test(description = "Add people")
    public void testAddPeople() {
        //Login
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.logIn("123@abc.com", "Pass1234");

        //Click on User & Settings icon in top right corner
        AddPeoplePage addPeoplePage = new AddPeoplePage(webDriver);
        addPeoplePage.clickHeaderAction("Users and Settings");

        //Click on Add People
        addPeoplePage.clickMenu("Add People");

        //Add some users into list
        String name = "Nhan Mai";
        String email = "nhanmai" + System.currentTimeMillis() + "@gmail.com";
        Map<String, String> userInfo = new HashMap<String, String>() {{
            put("Name", name);
            put("Email", email);
        }};
        addPeoplePage.addPersonAtRow(userInfo, 1);
        addPeoplePage.clickAddPeople();

        //Verify Congratulations page displays
        Assert.assertTrue(addPeoplePage.isCongratPageDisplayed());
    }
}
