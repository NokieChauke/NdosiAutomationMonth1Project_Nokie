package Tests;

import Base.BaseTest;
import Utilities.TestDataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, groups = "login")
    public void testLoginScenarios(String email, String password, String expectedMessage) {
        loginValidationSteps.loginWithValidDetails(email, password, expectedMessage);
    }
}
