package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends LoginTest {

    @Test
    public void navigateToTestimonialsPage() throws InterruptedException {
        loginWithValidDetails();
        learnPage.goToLearnPage();
        Thread.sleep(2000);
        learnPage.viewLearningMaterials();
        Thread.sleep(2000);
        learnPage.openWebAdvanceAutomationPage();
        Thread.sleep(2000);
        learnPage.viewAssessmentInstructions();
        Thread.sleep(2000);
        learnPage.selectDeviceType();
        Thread.sleep(2000);
        learnPage.brandDropdownIsEnabled();
        Thread.sleep(2000);
        learnPage.selectBrand();
        Thread.sleep(2000);
        learnPage.devicePreviewPanelDisplayed();
        Thread.sleep(2000);
        learnPage.selectStorageSize();
        Thread.sleep(2000);
        learnPage.unitPriceDisplayed();
        Thread.sleep(2000);
        learnPage.selectColor();
        Thread.sleep(2000);
        learnPage.colorSelectionApplied();
        Thread.sleep(2000);
        learnPage.enterQuantity();
        Thread.sleep(2000);
        learnPage.subtotalDisplayed();
        Thread.sleep(2000);
        learnPage.enterAddress();
        Thread.sleep(2000);
        learnPage.addressFieldIsFilled();
        Thread.sleep(2000);
        learnPage.clickNextButton();
        Thread.sleep(2000);
        learnPage.orderSummaryDisplayed();
        Thread.sleep(2000);
        learnPage.selectExpressShipping();
        Thread.sleep(2000);
        learnPage.shippingValueApplied();
        Thread.sleep(2000);
        learnPage.selectWarrantyOption();
        Thread.sleep(2000);
        learnPage.warrantyValueApplied();
        Thread.sleep(2000);
        learnPage.enterDiscountCode();
        Thread.sleep(2000);
        learnPage.applyDiscountCode();
        Thread.sleep(2000);
        learnPage.discountCodeApplied();
        Thread.sleep(2000);
        learnPage.confirmPurchase();
        Thread.sleep(2000);
        learnPage.purchaseSuccessToastDisplayed();
        Thread.sleep(2000);
        learnPage.clickViewInvoice();
        Thread.sleep(2000);
        learnPage.invoiceHistoryPanelDisplayed();
        Thread.sleep(2000);
        learnPage.clickViewInvoiceDetails();
        Thread.sleep(2000);
        learnPage.invoiceDetailsDisplayed();
    }
}
