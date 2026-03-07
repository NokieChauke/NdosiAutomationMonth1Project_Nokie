package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvoicePage {

    WebDriver driver;
    WebDriverWait wait;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "purchase-success-toast")
    WebElement purchaseSuccessToast;

    @FindBy(id = "view-history-btn")
    WebElement viewHistoryButton;

    @FindBy(id = "invoice-history-panel")
    WebElement invoiceHistoryPanel;

    @FindBy(xpath = ("//*[contains(@id, 'view-invoice-INV')]"))
    WebElement viewInvoiceButton;

    public void purchaseSuccessToastDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(purchaseSuccessToast));
        if (!purchaseSuccessToast.isDisplayed()) {
            throw new AssertionError("Purchase success toast is not displayed after confirming purchase.");
        }
    }

    public void clickViewInvoice() {
        wait.until(ExpectedConditions.elementToBeClickable(viewHistoryButton));
        viewHistoryButton.click();
    }

    public void invoiceHistoryPanelDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(invoiceHistoryPanel));
        if (!invoiceHistoryPanel.isDisplayed()) {
            throw new AssertionError("Invoice history panel is not displayed after clicking View Invoice.");
        }
    }

    public void clickViewInvoiceDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(viewInvoiceButton));
        viewInvoiceButton.click();
    }

    public void invoiceDetailsDisplayed() {
        wait.until(ExpectedConditions.urlContains("https://ndosisimplifiedautomation.vercel.app"));
        String expectedUL = "https://ndosisimplifiedautomation.vercel.app";
        String actualURL = driver.getCurrentUrl();
        if (!actualURL.contains(expectedUL)) {
            throw new AssertionError(
                    "Invoice details not displayed.");
        }
    }
}
