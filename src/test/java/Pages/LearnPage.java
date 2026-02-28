package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearnPage {
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]")
    WebElement learningMaterialsButton;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceButton;

    @FindBy(id = "assessment-instructions")
    WebElement assessmentInstructionsDropdown;


    public void goToLearnPage() {
        learnButton.click();
    }

    public void viewLearningMaterials() {
        learningMaterialsButton.click();
    }

    public void openWebAdvanceAutomationPage() {
        webAutomationAdvanceButton.click();}

    public void viewAssessmentInstructions() {assessmentInstructionsDropdown.click();}

}
