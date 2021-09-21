package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.CookiePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class CookieStep implements En {
    public CookieStep(
            CookiePage cookiePage,
            ScenarioContext scenario
    ){

        When("User get on **info cookies** page", () -> {
            cookiePage.goToCookiePage();
        });

        When("User click on support-apple", () -> {
            cookiePage.checkSupportApple();
        });

        Then("User should see effective content on support-apple", () -> {
           cookiePage.verifySupportApple();
           cookiePage.saveScreenShotPNG();
           Assert.assertEquals(cookiePage.verifySupportApple(),true);
        });

        When("User click on cookie network", () -> {
            cookiePage.checkCookieNetwork();
        });

        Then("User should see effective content on cookie network", () -> {
            cookiePage.verifyCookieNetwork();
            cookiePage.saveScreenShotPNG();
            Assert.assertEquals(cookiePage.verifyCookieNetwork(),true);
        });







    }
}
