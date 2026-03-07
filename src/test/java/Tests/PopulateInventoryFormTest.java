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

        loginSteps.performLogin(userEmail, userPassword, expectedLoginMessage);
        learnNavigationSteps.navigateToLearnPage();
        inventoryFormSteps.fillInventoryForm(selectedDeviceType, selectedBrand, unitPrice,
                selectedColor, colorValue, enteredQuantity, expectedSubtotal, deliveryAddress);
        orderSummarySteps.completeOrderSummary();
        invoiceSteps.verifyInvoice();
    }

}
