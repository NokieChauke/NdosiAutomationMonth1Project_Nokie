package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidDetails() throws InterruptedException {

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress("nokietest@mail.com");
        loginPage.enterPassword("125abc!Test");
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("Welcome back, Nokie! \uD83D\uDC4B");
    }

}
