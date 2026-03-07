package Tests;

import Base.BaseTest;
import Steps.LoginValidationSteps;
import Utilities.TestDataProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, groups = "login")
    public void testLoginScenarios(String email, String password, String expectedMessage) {
        LoginValidationSteps loginValidationSteps = new LoginValidationSteps(driver, loginPage);
        loginValidationSteps.loginWithValidDetails(email, password, expectedMessage);
    }
}
