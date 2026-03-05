package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSummaryPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "device-summary-list")
    WebElement summaryList;

    @FindBy(id = "shipping-option-express")
    WebElement expressShippingOption;

    @FindBy(id = "breakdown-shipping-value")
    WebElement breakdownShippingValue;

    @FindBy(id = "warranty-option-1yr")
    WebElement warrantyOption1yr;

    @FindBy(id = "breakdown-warranty-value")
    WebElement breakdownWarrantyValue;

    @FindBy(id = "discount-code")
    WebElement discountCodeInputField;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    @FindBy(id = "discount-feedback")
    WebElement discountFeedbackMessage;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseDeviceButton;

    public void orderSummaryDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(summaryList));
        if (!summaryList.isDisplayed()) {
            throw new AssertionError("Order summary list is not displayed after clicking Next.");
        }
    }

    public void selectExpressShipping() {
        wait.until(ExpectedConditions.elementToBeClickable(expressShippingOption));
        expressShippingOption.click();
    }

    public void shippingValueApplied() {
        wait.until(ExpectedConditions.visibilityOf(breakdownShippingValue));
        String expectedShippingValue = "R25.00";
        String actualShippingValue = breakdownShippingValue.getText();
        if (!actualShippingValue.equals(expectedShippingValue)) {
            throw new AssertionError(
                    "Expected shipping value: " + expectedShippingValue + ", but got: " + actualShippingValue);
        }
    }

    public void selectWarrantyOption() {
        wait.until(ExpectedConditions.elementToBeClickable(warrantyOption1yr));
        warrantyOption1yr.click();
    }

    public void warrantyValueApplied() {
        wait.until(ExpectedConditions.visibilityOf(breakdownWarrantyValue));
        String expectedWarrantyValue = "R49.00";
        String actualWarrantyValue = breakdownWarrantyValue.getText();
        if (!actualWarrantyValue.equals(expectedWarrantyValue)) {
            throw new AssertionError(
                    "Expected warranty value: " + expectedWarrantyValue + ", but got: " + actualWarrantyValue);
        }
    }

    public void enterDiscountCode() {
        wait.until(ExpectedConditions.visibilityOf(discountCodeInputField));
        discountCodeInputField.clear();
        discountCodeInputField.sendKeys("SAVE10");
    }

    public void applyDiscountCode() {
        wait.until(ExpectedConditions.elementToBeClickable(applyDiscountButton));
        applyDiscountButton.click();
    }

    public void discountCodeApplied() {
        wait.until(ExpectedConditions.visibilityOf(discountFeedbackMessage));
        String expectedFeedback = "Code SAVE10 applied: -10%";
        String actualFeedback = discountFeedbackMessage.getText();
        if (!actualFeedback.equals(expectedFeedback)) {
            throw new AssertionError(
                    "Expected discount feedback: " + expectedFeedback + ", but got: " + actualFeedback);
        }
    }

    public void confirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseDeviceButton));
        purchaseDeviceButton.click();
    }
}
