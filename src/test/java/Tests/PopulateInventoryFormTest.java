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
        Thread.sleep(3000);
        learnPage.viewAssessmentInstructions();
    }
}
