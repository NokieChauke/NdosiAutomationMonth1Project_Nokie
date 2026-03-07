package Steps;

import Pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void performLogin(String email, String password, String expectedMessage) {
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }
}
