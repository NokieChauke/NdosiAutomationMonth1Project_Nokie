package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement loginEmailField;

    @FindBy(id = "login-password")
    WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//h2[contains(text(), 'Welcome back')]")
    WebElement welcomeBackMessage;

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOf(loginEmailField));
        loginEmailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPasswordField));
        loginPasswordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(loginSubmitButton));
        loginSubmitButton.click();
    }

    public void verifyLoginSuccess(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(welcomeBackMessage));
        welcomeBackMessage.isDisplayed();
        String actualMessage = welcomeBackMessage.getText();
        if (!actualMessage.contains(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }
}
