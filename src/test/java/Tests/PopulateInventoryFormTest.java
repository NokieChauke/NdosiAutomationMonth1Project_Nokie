package Tests;

import Utilities.TestDataProvider;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends LoginTest {

    @Test(dataProvider = "inventoryData", dataProviderClass = TestDataProvider.class)
    public void inventoryFormTest(String deviceType, String brand, String unitPrice, String color, String colorValue, String quantity, String subtotal, String address) {

        loginWithDefaultCredentials();
        learnNavigationPage.goToLearnPage();
        learnNavigationPage.viewLearningMaterials();
        learnNavigationPage.openWebAdvanceAutomationPage();
        learnNavigationPage.viewAssessmentInstructions();
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
        orderSummaryPage.orderSummaryDisplayed();
        orderSummaryPage.selectExpressShipping();
        orderSummaryPage.shippingValueApplied();
        orderSummaryPage.selectWarrantyOption();
        orderSummaryPage.warrantyValueApplied();
        orderSummaryPage.enterDiscountCode();
        orderSummaryPage.applyDiscountCode();
        orderSummaryPage.discountCodeApplied();
        orderSummaryPage.confirmPurchase();
        invoicePage.purchaseSuccessToastDisplayed();
        invoicePage.clickViewInvoice();
        invoicePage.invoiceHistoryPanelDisplayed();
        invoicePage.clickViewInvoiceDetails();
        invoicePage.invoiceDetailsDisplayed();
    }
}
