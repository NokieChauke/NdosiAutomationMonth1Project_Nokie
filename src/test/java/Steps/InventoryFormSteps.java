package Steps;

import Pages.InventoryFormPage;

public class InventoryFormSteps {

    private InventoryFormPage inventoryFormPage;

    public InventoryFormSteps(InventoryFormPage inventoryFormPage) {
        this.inventoryFormPage = inventoryFormPage;
    }

    public void fillInventoryForm(String deviceType, String brand, String unitPrice, String color,
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
}
