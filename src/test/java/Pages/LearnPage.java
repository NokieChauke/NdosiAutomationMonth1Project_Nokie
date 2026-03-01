package Pages;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LearnPage {

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
        learnButton.click();
    }

    public void viewLearningMaterials() {
        learningMaterialsButton.click();
    }

    public void openWebAdvanceAutomationPage() {webAutomationAdvanceButton.click();}

    public void viewAssessmentInstructions() {assessmentInstructionsDropdown.click();}

    public void openInventoryForm() {webAutomationAdvanceButton.click();  }

    public void inventoryFormIsDisplayed() {
        if (!inventoryForm.isDisplayed()) {
            throw new AssertionError("Inventory Form' is not displayed.");
        }
    }

    public void selectDeviceType() {
        dropdown = new Select(deviceTypeDropdown);
        dropdown.selectByVisibleText("Phone");
    }

    public void brandDropdownIsEnabled() {
        if (!brandDropdown.isEnabled()) {
            throw new AssertionError(
                    "The 'Brand' dropdown is not enabled after selecting " +
                            "'Phone' as device type.");
        }
    }
    public void selectBrand() {
        dropdown = new Select(brandDropdown);
        dropdown.selectByVisibleText("Apple");
    }

    public void devicePreviewPanelDisplayed() {
        if (!imagePreview.isDisplayed()) {
            throw new AssertionError(
                    "The device preview panel is not displayed after selecting" +
                            " 'Apple' as brand.");
        }
    }

    public void selectStorageSize() {
        storageSizeRadioButton.click();
    }

    public void unitPriceDisplayed() {
        String expectedPrice = "R480.00";
        String actualPrice = unitPriceValue.getText();
        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError(
                    "Expected unit price: " + expectedPrice + ", but got: " + actualPrice);
        }
    }

    public void selectColor() {
        dropdown = new Select(colorDropdown);
        dropdown.selectByVisibleText("Blue");
    }
    public void colorSelectionApplied() {
        String expectedColor = "blue";
        String actualColor = deviceColor.getText();
        if (!actualColor.equals(expectedColor)) {
            throw new AssertionError(
                    "Expected device color: " + expectedColor + ", but got: " + actualColor);
        }
    }

    public void enterQuantity() {
        quantityInputField.clear();
        quantityInputField.sendKeys("2");
    }

    public void subtotalDisplayed() {
        String expectedSubtotal = "R960.00";
        String actualSubtotal = subtotalValue.getText();
        if (!actualSubtotal.equals(expectedSubtotal)) {
            throw new AssertionError(
                    "Expected subtotal: " + expectedSubtotal + ", but got: " + actualSubtotal);
        }
    }

    public void enterAddress() {
        addressInputField.clear();
        addressInputField.sendKeys("123 Test Street");
    }

    public void addressFieldIsFilled() {
        String expectedAddress = "123 Test Street";
        String actualAddress = addressInputField.getAttribute("value");
        if (!actualAddress.equals(expectedAddress)) {
            throw new AssertionError(
                    "Expected address: " + expectedAddress + ", but got: " + actualAddress);
        }
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void orderSummaryDisplayed() {
        if (!summaryList.isDisplayed()) {
            throw new AssertionError("Order summary list is not displayed after clicking Next.");
        }
    }

    public void selectExpressShipping() {
        expressShippingOption.click();
    }

    public void shippingValueApplied() {
        String expectedShippingValue = "R25.00";
        String actualShippingValue = breakdownShippingValue.getText();
        if (!actualShippingValue.equals(expectedShippingValue)) {
            throw new AssertionError(
                    "Expected shipping value: " + expectedShippingValue + ", but got: " + actualShippingValue);
        }
    }

    public void selectWarrantyOption() {
        warrantyOption1yr.click();
    }

    public void warrantyValueApplied() {
        String expectedWarrantyValue = "R49.00";
        String actualWarrantyValue = breakdownWarrantyValue.getText();
        if (!actualWarrantyValue.equals(expectedWarrantyValue)) {
            throw new AssertionError(
                    "Expected warranty value: " + expectedWarrantyValue + ", but got: " + actualWarrantyValue);
        }
    }

    public void enterDiscountCode() {
        discountCodeInputField.clear();
        discountCodeInputField.sendKeys("SAVE10");
    }

    public void applyDiscountCode() {
        applyDiscountButton.click();
    }

    public void discountCodeApplied() {
        String expectedFeedback = "Code SAVE10 applied: -10%";
        String actualFeedback = discountFeedbackMessage.getText();
        if (!actualFeedback.equals(expectedFeedback)) {
            throw new AssertionError(
                    "Expected discount feedback: " + expectedFeedback + ", but got: " + actualFeedback);
        }
    }

    public void confirmPurchase() {
        purchaseDeviceButton.click();
    }

    public void purchaseSuccessToastDisplayed() {
        if (!purchaseSuccessToast.isDisplayed()) {
            throw new AssertionError("Purchase success toast is not displayed after confirming purchase.");
        }
    }

    public void clickViewInvoice() {
        viewHistoryButton.click();
    }

    public void invoiceHistoryPanelDisplayed() {
        if (!invoiceHistoryPanel.isDisplayed()) {
            throw new AssertionError("Invoice history panel is not displayed after clicking View Invoice.");
        }
    }

    public void clickViewInvoiceDetails() {
        viewInvoiceButton.click();
    }

    public void invoiceDetailsDisplayed() {
        BrowserFactory browserFactory = new BrowserFactory();
        String expectedUL = "https://ndosisimplifiedautomation.vercel.app";
        String actualURL = browserFactory.getCurrentURL();
        if (!actualURL.contains(expectedUL)) {
            throw new AssertionError(
                    "Invoice details not displayed.");
        }
    }
}
