package Base;

import Pages.*;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver;
    public LoginPage loginPage;
    public LearnNavigationPage learnNavigationPage;
    public InventoryFormPage inventoryFormPage;
    public OrderSummaryPage orderSummaryPage;
    public InvoicePage invoicePage;

    @BeforeSuite
    public void setUp() {
        // Initialize browser
        driver = BrowserFactory.startBrowser(browserChoice, url);

        // Initialize page objects
        loginPage = new LoginPage(driver);
        learnNavigationPage = new LearnNavigationPage(driver);
        inventoryFormPage = new InventoryFormPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        invoicePage = new InvoicePage(driver);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        // Wait before closing browser to ensure all operations complete
        Thread.sleep(1000);

        // Close browser and cleanup resources
        if (driver != null) {
            driver.quit();
        }
    }

}
