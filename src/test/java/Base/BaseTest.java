package Base;

import Pages.*;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public final WebDriver driver = BrowserFactory.startBrowser(browserChoice, url);
    public LoginPage loginPage = new LoginPage(driver);
    public LearnNavigationPage learnNavigationPage = new LearnNavigationPage(driver);
    public InventoryFormPage inventoryFormPage = new InventoryFormPage(driver);
    public OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
    public InvoicePage invoicePage = new InvoicePage(driver);

}
