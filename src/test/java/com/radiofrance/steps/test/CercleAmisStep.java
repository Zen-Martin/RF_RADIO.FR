package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.CercleAmisPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class CercleAmisStep implements En {

    public CercleAmisStep(
            CercleAmisPage cercleAmisPage,
            ScenarioContext scenario
    ){

        When("User get on **cercle des amis** page", () -> {
            cercleAmisPage.goToCercleAmisPage();
        });

        And("User click on specific link", () -> {
            cercleAmisPage.checkLink_1();
        });

        Then("User should see effective content depend on link*", () -> {
            cercleAmisPage.goToDonate();
        });

        And("User get on **another page** check specific links", () -> {
            cercleAmisPage.checkLink_2();
        });

        Then("user should see same content", () -> {
            cercleAmisPage.verifyLinkRedirection();
            cercleAmisPage.saveScreenShotPNG();
            Assert.assertEquals(cercleAmisPage.verifyLinkRedirection(),true);
        });




    }


}
