package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.BrochurePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class BrochureStep implements En {

    public BrochureStep(
            BrochurePage brochurePage,
            ScenarioContext scenario
    ){

        When("User get on **brochures** page", () -> {
            brochurePage.goToBrochurePage();
        });

        And("User click on brochure", () -> {
            brochurePage.checkLink();
        });

        Then("User should see effective content on brochure", () -> {
            brochurePage.verifyLinkRedirection();
            brochurePage.saveScreenShotPNG();
            Assert.assertEquals(brochurePage.verifyLinkRedirection(),true);
        });




    }



}
