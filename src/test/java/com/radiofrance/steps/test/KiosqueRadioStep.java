package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.KiosqueRadioPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class KiosqueRadioStep implements En {

    public KiosqueRadioStep(
            KiosqueRadioPage kiosqueRadioPage,
            ScenarioContext scenario
    ){

        When("User get on **production edition radio recompensee** page", () -> {
            kiosqueRadioPage.goToKiosqueRadioPage();
        });

        And("User click on kiosque-radio link", () -> {
            kiosqueRadioPage.checkLink();
        });

        Then("User should see effective kiosque-radio content", () -> {
            kiosqueRadioPage.verifyKiosqueRadioLink();
            kiosqueRadioPage.saveScreenShotPNG();
            Assert.assertEquals(kiosqueRadioPage.verifyKiosqueRadioLink(),true);
        });





    }

}
