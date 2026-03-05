package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LearnPage {

    WebDriver driver;
    WebDriverWait wait;

    public LearnPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    Select dropdown;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]")
    WebElement learningMaterialsButton;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceButton;

    @FindBy(id = "inventory-form")
    WebElement inventoryForm;

    @FindBy(id = "assessment-instructions")
    WebElement assessmentInstructionsDropdown;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(xpath = "//*[@id=\"device-preview\"]/div/img")
    WebElement imagePreview;

    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[4]/div/label[2]")
    WebElement storageSizeRadioButton;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(xpath = "//*[@id=\"device-preview\"]/div/div/div[3]/strong[1]")
    WebElement deviceColor;

    @FindBy(id = "quantity")
    WebElement quantityInputField;

    @FindBy(id = "address")
    WebElement addressInputField;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

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

    @FindBy(id = "breakdown-total-value")
    WebElement breakdownTotalValue;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseDeviceButton;

    @FindBy(id = "purchase-success-toast")
    WebElement purchaseSuccessToast;

    @FindBy(id = "view-history-btn")
    WebElement viewHistoryButton;

    @FindBy(id = "invoice-history-panel")
    WebElement invoiceHistoryPanel;

    @FindBy(xpath = ("//*[contains(@id, 'view-invoice-INV')]"))
    WebElement viewInvoiceButton;



    public void goToLearnPage() {
        wait.until(ExpectedConditions.elementToBeClickable(learnButton));
        learnButton.click();
    }

    public void viewLearningMaterials() {
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsButton));
        learningMaterialsButton.click();
    }

    public void openWebAdvanceAutomationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdvanceButton));
        webAutomationAdvanceButton.click();
    }

    public void viewAssessmentInstructions() {
        wait.until(ExpectedConditions.elementToBeClickable(assessmentInstructionsDropdown));
        assessmentInstructionsDropdown.click();
    }

//    public void openInventoryForm() {webAutomationAdvanceButton.click();  }
//
//    public void inventoryFormIsDisplayed() {
//        if (!inventoryForm.isDisplayed()) {
//            throw new AssertionError("Inventory Form' is not displayed.");
//        }
//    }

    public void selectDeviceType() {
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeDropdown));
        dropdown = new Select(deviceTypeDropdown);
        dropdown.selectByVisibleText("Phone");
    }

    public void brandDropdownIsEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        if (!brandDropdown.isEnabled()) {
            throw new AssertionError(
                    "The 'Brand' dropdown is not enabled after selecting " +
                            "'Phone' as device type.");
        }
    }
    public void selectBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        dropdown = new Select(brandDropdown);
        dropdown.selectByVisibleText("Apple");
    }

    public void devicePreviewPanelDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(imagePreview));
        if (!imagePreview.isDisplayed()) {
            throw new AssertionError(
                    "The device preview panel is not displayed after selecting" +
                            " 'Apple' as brand.");
        }
    }

    public void selectStorageSize() {
        wait.until(ExpectedConditions.elementToBeClickable(storageSizeRadioButton));
        storageSizeRadioButton.click();
    }

    public void unitPriceDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(unitPriceValue));
        String expectedPrice = "R480.00";
        String actualPrice = unitPriceValue.getText();
        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError(
                    "Expected unit price: " + expectedPrice + ", but got: " + actualPrice);
        }
    }

    public void selectColor() {
        wait.until(ExpectedConditions.elementToBeClickable(colorDropdown));
        dropdown = new Select(colorDropdown);
        dropdown.selectByVisibleText("Blue");
    }
    public void colorSelectionApplied() {
        wait.until(ExpectedConditions.visibilityOf(deviceColor));
        String expectedColor = "blue";
        String actualColor = deviceColor.getText();
        if (!actualColor.equals(expectedColor)) {
            throw new AssertionError(
                    "Expected device color: " + expectedColor + ", but got: " + actualColor);
        }
    }

    public void enterQuantity() {
        wait.until(ExpectedConditions.visibilityOf(quantityInputField));
        quantityInputField.clear();
        quantityInputField.sendKeys("2");
    }

    public void subtotalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(subtotalValue));
        String expectedSubtotal = "R960.00";
        String actualSubtotal = subtotalValue.getText();
        if (!actualSubtotal.equals(expectedSubtotal)) {
            throw new AssertionError(
                    "Expected subtotal: " + expectedSubtotal + ", but got: " + actualSubtotal);
        }
    }

    public void enterAddress() {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
        addressInputField.clear();
        addressInputField.sendKeys("123 Test Street");
    }

    public void addressFieldIsFilled() {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
        String expectedAddress = "123 Test Street";
        String actualAddress = addressInputField.getAttribute("value");
        if (!actualAddress.equals(expectedAddress)) {
            throw new AssertionError(
                    "Expected address: " + expectedAddress + ", but got: " + actualAddress);
        }
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

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
