package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.ArticleCulturePage;
import com.radiofrance.pageObjects.BrochurePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class ArticleCultureStep implements En {

    public ArticleCultureStep(
            ArticleCulturePage articleCulturePage,
            ScenarioContext scenario
    ){
        When("User get on **article culture** page", () -> {
            articleCulturePage.goToArticleCulturePage();
        });

        And("User click on article culture n16 link", () -> {
            articleCulturePage.checkLink();
        });

        Then("User should see effective article culture n16 content", () -> {
            articleCulturePage.verifyArticleCultureContent();
            articleCulturePage.saveScreenShotPNG();
            Assert.assertEquals(articleCulturePage.verifyArticleCultureContent(),true);
        });





    }


}
