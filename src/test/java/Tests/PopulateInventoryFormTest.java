package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends LoginTest {

    @Test
    public void navigateToTestimonialsPage() throws InterruptedException {
        loginWithValidDetails();
        learnPage.goToLearnPage();
        learnPage.viewLearningMaterials();
        learnPage.openWebAdvanceAutomationPage();
        learnPage.viewAssessmentInstructions();
        learnPage.selectDeviceType();
        learnPage.brandDropdownIsEnabled();
        learnPage.selectBrand();
        learnPage.devicePreviewPanelDisplayed();
        learnPage.selectStorageSize();
        learnPage.unitPriceDisplayed();
        learnPage.selectColor();
        learnPage.colorSelectionApplied();
        learnPage.enterQuantity();
        learnPage.subtotalDisplayed();
        learnPage.enterAddress();
        learnPage.addressFieldIsFilled();
        learnPage.clickNextButton();
        learnPage.orderSummaryDisplayed();
        learnPage.selectExpressShipping();
        learnPage.shippingValueApplied();
        learnPage.selectWarrantyOption();
        learnPage.warrantyValueApplied();
        learnPage.enterDiscountCode();
        learnPage.applyDiscountCode();
        learnPage.discountCodeApplied();
        learnPage.confirmPurchase();
        learnPage.purchaseSuccessToastDisplayed();
        learnPage.clickViewInvoice();
        learnPage.invoiceHistoryPanelDisplayed();
        learnPage.clickViewInvoiceDetails();
        learnPage.invoiceDetailsDisplayed();
    }
}
