package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryFormPage {

    WebDriver driver;
    WebDriverWait wait;
    Select dropdown;

    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

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

    public void selectDeviceType() {
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeDropdown));
        dropdown = new Select(deviceTypeDropdown);
        dropdown.selectByVisibleText("Phone");
    }

    public void brandDropdownIsEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        if (!brandDropdown.isEnabled()) {
            throw new AssertionError(
                    "The 'Brand' dropdown is not enabled after selecting " +
                            "'Phone' as device type.");
        }
    }

    public void selectBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        dropdown = new Select(brandDropdown);
        dropdown.selectByVisibleText("Apple");
    }

    public void devicePreviewPanelDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(imagePreview));
        if (!imagePreview.isDisplayed()) {
            throw new AssertionError(
                    "The device preview panel is not displayed after selecting" +
                            " 'Apple' as brand.");
        }
    }

    public void selectStorageSize() {
        wait.until(ExpectedConditions.elementToBeClickable(storageSizeRadioButton));
        storageSizeRadioButton.click();
    }

    public void unitPriceDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(unitPriceValue));
        String expectedPrice = "R480.00";
        String actualPrice = unitPriceValue.getText();
        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError(
                    "Expected unit price: " + expectedPrice + ", but got: " + actualPrice);
        }
    }

    public void selectColor() {
        wait.until(ExpectedConditions.elementToBeClickable(colorDropdown));
        dropdown = new Select(colorDropdown);
        dropdown.selectByVisibleText("Blue");
    }

    public void colorSelectionApplied() {
        wait.until(ExpectedConditions.visibilityOf(deviceColor));
        String expectedColor = "blue";
        String actualColor = deviceColor.getText();
        if (!actualColor.equals(expectedColor)) {
            throw new AssertionError(
                    "Expected device color: " + expectedColor + ", but got: " + actualColor);
        }
    }

    public void enterQuantity() {
        wait.until(ExpectedConditions.visibilityOf(quantityInputField));
        quantityInputField.clear();
        quantityInputField.sendKeys("2");
    }

    public void subtotalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(subtotalValue));
        String expectedSubtotal = "R960.00";
        String actualSubtotal = subtotalValue.getText();
        if (!actualSubtotal.equals(expectedSubtotal)) {
            throw new AssertionError(
                    "Expected subtotal: " + expectedSubtotal + ", but got: " + actualSubtotal);
        }
    }

    public void enterAddress() {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
        addressInputField.clear();
        addressInputField.sendKeys("123 Test Street");
    }

    public void addressFieldIsFilled() {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
        String expectedAddress = "123 Test Street";
        String actualAddress = addressInputField.getAttribute("value");
        if (!actualAddress.equals(expectedAddress)) {
            throw new AssertionError(
                    "Expected address: " + expectedAddress + ", but got: " + actualAddress);
        }
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }
}
