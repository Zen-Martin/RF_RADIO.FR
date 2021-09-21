package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.ChoeurRadioPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class ChoeurRadioStep implements En {

    public ChoeurRadioStep(
            ChoeurRadioPage choeurRadioPage,
            ScenarioContext scenario
    ){

        When("User get on **choeur de radio** page", () -> {
            choeurRadioPage.goToChoeurDeRadioPage();
        });

        When("User click on differents links", () -> {
            choeurRadioPage.checkLink();
        });

        Then("User should see effective content depend on links", () -> {
            choeurRadioPage.verifyLinkRedirection();
            choeurRadioPage.saveScreenShotPNG();
            Assert.assertEquals(choeurRadioPage.verifyLinkRedirection(),true);
        });



    }

}
