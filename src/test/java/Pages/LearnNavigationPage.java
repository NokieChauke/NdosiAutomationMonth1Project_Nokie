package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LearnNavigationPage {

    WebDriver driver;
    WebDriverWait wait;

    public LearnNavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]")
    WebElement learningMaterialsButton;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceButton;

    @FindBy(id = "assessment-instructions")
    WebElement assessmentInstructionsDropdown;

    public void goToLearnPage() {
        wait.until(ExpectedConditions.elementToBeClickable(learnButton));
        learnButton.click();
    }

    public void viewLearningMaterials() {
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsButton));
        learningMaterialsButton.click();
    }

    public void openWebAdvanceAutomationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdvanceButton));
        webAutomationAdvanceButton.click();
    }

    public void viewAssessmentInstructions() {
        wait.until(ExpectedConditions.elementToBeClickable(assessmentInstructionsDropdown));
        assessmentInstructionsDropdown.click();
    }
}
