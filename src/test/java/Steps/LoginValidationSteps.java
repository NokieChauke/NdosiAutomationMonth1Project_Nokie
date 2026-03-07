package Steps;

import Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.LoginPage;

import java.time.Duration;

public class LoginValidationSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginValidationSteps(WebDriver driver, LoginPage loginPage) {
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public void loginWithValidDetails(String email, String password, String expectedMessage) {
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check if alert is present (for invalid credentials)
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals(expectedMessage)) {
                alert.accept();
            } else {
                throw new AssertionError("Expected alert message: " + expectedMessage + ", but got: " + alertText);
            }
        } catch (Exception e) {
            // No alert, so verify success message
            loginPage.verifyLoginSuccess(expectedMessage);
        }
    }
}
