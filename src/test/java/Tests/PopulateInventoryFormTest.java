package Tests;

import Base.BaseTest;
import Steps.*;
import Utilities.TestDataProvider;
import org.testng.annotations.Test;

public class PopulateInventoryFormTest extends BaseTest {

    @Test(dataProvider = "inventoryData", dataProviderClass = TestDataProvider.class, groups = "inventory")
    public void testPopulateInventoryForm(String userEmail, String userPassword, String expectedLoginMessage,
                                  String selectedDeviceType, String selectedBrand, String unitPrice, String selectedColor,
                                  String colorValue, String enteredQuantity, String expectedSubtotal, String deliveryAddress) {

        LoginSteps loginSteps = new LoginSteps(loginPage);
        loginSteps.performLogin(userEmail, userPassword, expectedLoginMessage);

        LearnNavigationSteps learnSteps = new LearnNavigationSteps(learnNavigationPage);
        learnSteps.navigateToLearnPage();

        InventoryFormSteps inventorySteps = new InventoryFormSteps(inventoryFormPage);
        inventorySteps.fillInventoryForm(selectedDeviceType, selectedBrand, unitPrice, selectedColor, colorValue, enteredQuantity, expectedSubtotal, deliveryAddress);

        OrderSummarySteps orderSteps = new OrderSummarySteps(orderSummaryPage);
        orderSteps.completeOrderSummary();

        InvoiceSteps invoiceSteps = new InvoiceSteps(invoicePage);
        invoiceSteps.verifyInvoice();
    }

}
