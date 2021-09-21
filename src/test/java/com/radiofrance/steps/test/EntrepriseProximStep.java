package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.EntrepriseProximPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class EntrepriseProximStep implements En {

    public EntrepriseProximStep(
            EntrepriseProximPage entrepriseProximPage,
            ScenarioContext scenario
    ){

        When("User get on **entreprise proximite** page", () -> {
            entrepriseProximPage.goToEnsProximPage();
        });

        When("User click on the voice", () -> {
            entrepriseProximPage.checkLink();
        });

        Then("User should see effective content on voice", () -> {
            entrepriseProximPage.verifyLinkRedirection();
            entrepriseProximPage.saveScreenShotPNG();
            Assert.assertEquals(entrepriseProximPage.verifyLinkRedirection(),true);
        });





    }


}
