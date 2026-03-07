package Base;

import Navigations.LearnNavigationPage;
import Pages.*;
import Steps.*;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.security.PublicKey;

public class BaseTest {

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver;
    public LoginPage loginPage;
    public LearnNavigationPage learnNavigationPage;
    public InventoryFormPage inventoryFormPage;
    public OrderSummaryPage orderSummaryPage;
    public InvoicePage invoicePage;
    public InventoryFormSteps inventoryFormSteps;
    public InvoiceSteps invoiceSteps;
    public LearnNavigationSteps learnNavigationSteps;
    public LoginSteps loginSteps;
    public LoginValidationSteps loginValidationSteps;
    public OrderSummarySteps orderSummarySteps;


    @BeforeMethod
    public void setUp() {
        // Initialize browser
        driver = BrowserFactory.startBrowser(browserChoice, url);

        // Initialize page objects
        loginPage = new LoginPage(driver);
        learnNavigationPage = new LearnNavigationPage(driver);
        inventoryFormPage = new InventoryFormPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        invoicePage = new InvoicePage(driver);
        // Initialize step classes
        inventoryFormSteps = new InventoryFormSteps(inventoryFormPage);
        invoiceSteps = new InvoiceSteps(invoicePage);
        learnNavigationSteps = new LearnNavigationSteps(learnNavigationPage);
        loginSteps = new LoginSteps(loginPage);
        loginValidationSteps = new LoginValidationSteps(driver, loginPage);
        orderSummarySteps = new OrderSummarySteps(orderSummaryPage);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Wait before closing browser to ensure all operations complete
        Thread.sleep(1000);

        // Close browser and cleanup resources
        if (driver != null) {
            driver.quit();
        }
    }

}
