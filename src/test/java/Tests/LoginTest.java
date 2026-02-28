package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidDetails() throws InterruptedException {

        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.enterEmailAddress("Nokiechauke@gmail.com");
        loginPage.enterPassword("MuyiWaMina#1");
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(3000);
        loginPage.verifyLoginSuccess("Welcome back, Nokie! \uD83D\uDC4B");
    }

}
