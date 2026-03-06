package Tests;

import Base.BaseTest;
import Utilities.TestDataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, groups = "login")
    public void testLoginScenarios(String email, String password, String expectedMessage) {
        loginWithValidDetails(email, password, expectedMessage);
    }

    public void loginWithValidDetails(String email, String password, String expectedMessage) {

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

}
