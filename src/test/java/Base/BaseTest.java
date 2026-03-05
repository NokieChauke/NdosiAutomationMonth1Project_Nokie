package Base;

import Pages.LoginPage;
import Pages.LearnPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public final WebDriver driver = BrowserFactory.startBrowser(browserChoice, url);
    public LoginPage loginPage = new LoginPage(driver);
    public LearnPage learnPage = new LearnPage(driver);

}
