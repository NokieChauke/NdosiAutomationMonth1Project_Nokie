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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(xpath = "//div[@data-testid='device-preview']")
    WebElement imagePreview;

    @FindBy(xpath = "//input[@name='storage' and @value='128GB']")
    WebElement storageSizeRadioButton;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(xpath = "//div[@data-testid='device-preview']//strong[contains(text(),'blue')]")
    WebElement deviceColor;

    @FindBy(id = "quantity")
    WebElement quantityInputField;

    @FindBy(id = "address")
    WebElement addressInputField;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    public void selectDeviceType(String deviceType) {
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeDropdown));
        dropdown = new Select(deviceTypeDropdown);
        dropdown.selectByVisibleText(deviceType);
    }

    public void brandDropdownIsEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        if (!brandDropdown.isEnabled()) {
            throw new AssertionError(
                    "The 'Brand' dropdown is not enabled after selecting device type.");
        }
    }
    public void selectBrand(String brand) {
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        dropdown = new Select(brandDropdown);
        dropdown.selectByVisibleText(brand);
    }

    public void devicePreviewPanelDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(imagePreview));
        if (!imagePreview.isDisplayed()) {
            throw new AssertionError(
                    "The device preview panel is not displayed after selecting brand.");
        }
    }

    public void selectStorageSize() {
        wait.until(ExpectedConditions.elementToBeClickable(storageSizeRadioButton));
        storageSizeRadioButton.click();
    }

    public void unitPriceDisplayed(String expectedPrice) {
        wait.until(ExpectedConditions.visibilityOf(unitPriceValue));
        String actualPrice = unitPriceValue.getText();
        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError(
                    "Expected unit price: " + expectedPrice + ", but got: " + actualPrice);
        }
    }

    public void selectColor(String color) {
        wait.until(ExpectedConditions.elementToBeClickable(colorDropdown));
        dropdown = new Select(colorDropdown);
        dropdown.selectByVisibleText(color);
    }
    public void colorSelectionApplied(String expectedColor) {
        wait.until(ExpectedConditions.visibilityOf(deviceColor));
        String actualColor = deviceColor.getText();
        if (!actualColor.equals(expectedColor)) {
            throw new AssertionError(
                    "Expected device color: " + expectedColor + ", but got: " + actualColor);
        }
    }

    public void enterQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(quantityInputField));
        quantityInputField.clear();
        quantityInputField.sendKeys(quantity);
    }

    public void subtotalDisplayed(String expectedSubtotal) {
        wait.until(ExpectedConditions.visibilityOf(subtotalValue));
        String actualSubtotal = subtotalValue.getText();
        if (!actualSubtotal.equals(expectedSubtotal)) {
            throw new AssertionError(
                    "Expected subtotal: " + expectedSubtotal + ", but got: " + actualSubtotal);
        }
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
        addressInputField.clear();
        addressInputField.sendKeys(address);
    }

    public void addressFieldIsFilled(String expectedAddress) {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
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
