package Base;

import Pages.LoginPage;
import Pages.LearnPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();

     public final String url = "https://ndosisimplifiedautomation.vercel.app/";
     public final String browserChoice = "chrome";

     public WebDriver driver;
     public LoginPage loginPage;
     public LearnPage learnPage = PageFactory.initElements(driver, LearnPage.class);

    @BeforeClass
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url);
        loginPage  =new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        browserFactory.closeBrowser();
    }
}
