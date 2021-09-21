package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.ItaliaPricePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class ItaliaPriceStep implements En {

    public ItaliaPriceStep(
            ItaliaPricePage italiaPricePage,
            ScenarioContext scenario
    ){
        When("User get on **prix italia** page", () -> {
            italiaPricePage.goToItaliaPricePage();
        });

        And("User click on lemouv link", () -> {
            italiaPricePage.checkLemouvLink();
        });

        Then("User should see effective lemouv content", () -> {
            italiaPricePage.verifyLemouvLink();
            italiaPricePage.saveScreenShotPNG();
            Assert.assertEquals(italiaPricePage.verifyLemouvLink(),true);
        });




    }

}
