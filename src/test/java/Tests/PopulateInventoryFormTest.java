package Tests;

import Base.BaseTest;
import Utilities.TestDataProvider;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends BaseTest {

    @Test(dataProvider = "inventoryData", dataProviderClass = TestDataProvider.class, groups = "inventory")
    public void inventoryFormTest(String email, String password, String expectedMessage,
                                  String deviceType, String brand, String unitPrice, String color,
                                  String colorValue, String quantity, String subtotal, String address) {

        // Login with valid credentials
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess(expectedMessage);

        // Navigate to Learn page
        learnNavigationPage.goToLearnPage();
        learnNavigationPage.viewLearningMaterials();
        learnNavigationPage.openWebAdvanceAutomationPage();
        learnNavigationPage.viewAssessmentInstructions();

        // Fill inventory form
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

        // Complete order summary
        orderSummaryPage.orderSummaryDisplayed();
        orderSummaryPage.selectExpressShipping();
        orderSummaryPage.shippingValueApplied();
        orderSummaryPage.selectWarrantyOption();
        orderSummaryPage.warrantyValueApplied();
        orderSummaryPage.enterDiscountCode();
        orderSummaryPage.applyDiscountCode();
        orderSummaryPage.discountCodeApplied();
        orderSummaryPage.confirmPurchase();

        // Verify purchase and invoice
        invoicePage.purchaseSuccessToastDisplayed();
        invoicePage.clickViewInvoice();
        invoicePage.invoiceHistoryPanelDisplayed();
        invoicePage.clickViewInvoiceDetails();
        invoicePage.invoiceDetailsDisplayed();
    }
}
