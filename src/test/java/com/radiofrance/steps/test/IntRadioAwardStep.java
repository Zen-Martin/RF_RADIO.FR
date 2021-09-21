package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.IntRadioAwardPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class IntRadioAwardStep implements En {

    public IntRadioAwardStep(
            IntRadioAwardPage intRadioAwardPage,
            ScenarioContext scenario
    ){
        When("User get on **radio france new-york recompense** page", () -> {
            intRadioAwardPage.goToIntRadioAwardPage();
        });

        And("User click on international-radio-award link", () -> {
            intRadioAwardPage.checkLink();
        });

        Then("User should see effective international-radio-award content", () -> {
            intRadioAwardPage.verifyIntRadioAwardLink();
            intRadioAwardPage.saveScreenShotPNG();
            Assert.assertEquals(intRadioAwardPage.verifyIntRadioAwardLink(),true);
        });



    }

}
