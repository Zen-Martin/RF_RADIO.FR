package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.EditionRadioFrPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class EditionRadioFrStep implements En {

    public EditionRadioFrStep(
            EditionRadioFrPage editionRadioFrPage,
            ScenarioContext scenario
    ){

        When("User get on **editions radio france recompensees** page", () -> {
            editionRadioFrPage.goToEditionRadioPage();
        });

        And("User click on algeria_war link", () -> {
            editionRadioFrPage.checkAlgeriaWarLink();
        });

        And("User get back on **previous page** check specific links", () -> {
            editionRadioFrPage.checkOthersLinks();
        });

        Then("user should see effectives contents", () -> {
            editionRadioFrPage.verifyLinkContent();
            editionRadioFrPage.saveScreenShotPNG();
            Assert.assertEquals(editionRadioFrPage.verifyLinkContent(),true);
        });







    }


}
