package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends LoginTest {

    @Test
    public void navigateToTestimonialsPage() throws InterruptedException {
        loginWithValidDetails();
        learnNavigationPage.goToLearnPage();
        learnNavigationPage.viewLearningMaterials();
        learnNavigationPage.openWebAdvanceAutomationPage();
        learnNavigationPage.viewAssessmentInstructions();
        inventoryFormPage.selectDeviceType();
        inventoryFormPage.brandDropdownIsEnabled();
        inventoryFormPage.selectBrand();
        inventoryFormPage.devicePreviewPanelDisplayed();
        inventoryFormPage.selectStorageSize();
        inventoryFormPage.unitPriceDisplayed();
        inventoryFormPage.selectColor();
        inventoryFormPage.colorSelectionApplied();
        inventoryFormPage.enterQuantity();
        inventoryFormPage.subtotalDisplayed();
        inventoryFormPage.enterAddress();
        inventoryFormPage.addressFieldIsFilled();
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
