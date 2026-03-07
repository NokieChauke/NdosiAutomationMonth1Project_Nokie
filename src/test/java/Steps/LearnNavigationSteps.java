package Steps;

import Navigations.LearnNavigationPage;

public class LearnNavigationSteps {

    private LearnNavigationPage learnNavigationPage;

    public LearnNavigationSteps(LearnNavigationPage learnNavigationPage) {
        this.learnNavigationPage = learnNavigationPage;
    }

    public void navigateToLearnPage() {
        learnNavigationPage.goToLearnPage();
        learnNavigationPage.viewLearningMaterials();
        learnNavigationPage.openWebAdvanceAutomationPage();
        learnNavigationPage.viewAssessmentInstructions();
    }
}
