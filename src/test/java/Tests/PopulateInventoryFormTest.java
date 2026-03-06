package Tests;

import Base.BaseTest;
import Utilities.TestDataProvider;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends BaseTest {

    @Test(dataProvider = "inventoryData", dataProviderClass = TestDataProvider.class, groups = "inventory")
    public void testPopulateInventoryForm(String userEmail, String userPassword, String expectedLoginMessage,
                                  String selectedDeviceType, String selectedBrand, String unitPrice, String selectedColor,
                                  String colorValue, String enteredQuantity, String expectedSubtotal, String deliveryAddress) {

        performLogin(userEmail, userPassword, expectedLoginMessage);
        navigateToLearnPage();
        fillInventoryForm(selectedDeviceType, selectedBrand, unitPrice, selectedColor, colorValue, enteredQuantity, expectedSubtotal, deliveryAddress);
        completeOrderSummary();
        verifyInvoice();
    }

    private void performLogin(String email, String password, String expectedMessage) {
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);
    }

    private void navigateToLearnPage() {
        learnNavigationPage.goToLearnPage();
        learnNavigationPage.viewLearningMaterials();
        learnNavigationPage.openWebAdvanceAutomationPage();
        learnNavigationPage.viewAssessmentInstructions();
    }

    private void fillInventoryForm(String deviceType, String brand, String unitPrice, String color,
                                   String colorValue, String quantity, String subtotal, String address) {
        inventoryFormPage.selectDeviceType(deviceType);
        inventoryFormPage.brandDropdownIsEnabled();
        inventoryFormPage.selectBrand(brand);
        inventoryFormPage.devicePreviewPanelDisplayed();
        inventoryFormPage.selectStorageSize();
        inventoryFormPage.unitPriceDisplayed(unitPrice);
        inventoryFormPage.selectColor(color);
        inventoryFormPage.colorSelectionApplied(colorValue);
        inventoryFormPage.enterQuantity(quantity);
        inventoryFormPage.subtotalDisplayed(subtotal);
        inventoryFormPage.enterAddress(address);
        inventoryFormPage.addressFieldIsFilled(address);
        inventoryFormPage.clickNextButton();
    }

    private void completeOrderSummary() {
        orderSummaryPage.orderSummaryDisplayed();
        orderSummaryPage.selectExpressShipping();
        orderSummaryPage.shippingValueApplied();
        orderSummaryPage.selectWarrantyOption();
        orderSummaryPage.warrantyValueApplied();
        orderSummaryPage.enterDiscountCode();
        orderSummaryPage.applyDiscountCode();
        orderSummaryPage.discountCodeApplied();
        orderSummaryPage.confirmPurchase();
    }

    private void verifyInvoice() {
        invoicePage.purchaseSuccessToastDisplayed();
        invoicePage.clickViewInvoice();
        invoicePage.invoiceHistoryPanelDisplayed();
        invoicePage.clickViewInvoiceDetails();
        invoicePage.invoiceDetailsDisplayed();
    }
}
