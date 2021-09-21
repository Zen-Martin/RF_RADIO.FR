package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.KiosqueRadioPage;
import com.radiofrance.pageObjects.SceneFrPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class SceneFrStep implements En {

    public SceneFrStep(
            SceneFrPage sceneFrPage,
            ScenarioContext scenario
    ){

        When("User get on **scene française** page", () -> {
            sceneFrPage.goToSceneFrPage();
        });

        And("User click on two specific links", () -> {
           sceneFrPage.checkLinks();
        });

        Then("User should see two effectives content depend on link", () -> {
            sceneFrPage.verifySceneFrLinks();
            sceneFrPage.saveScreenShotPNG();
            Assert.assertEquals(sceneFrPage.verifySceneFrLinks(),true);
        });




    }



}
