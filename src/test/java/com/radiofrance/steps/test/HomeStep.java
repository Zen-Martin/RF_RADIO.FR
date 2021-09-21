package com.radiofrance.steps.test;

import com.radiofrance.context.ScenarioContext;
import com.radiofrance.pageObjects.HomePage;
import io.cucumber.java8.En;

public class HomeStep implements En {

    public HomeStep(
            HomePage homePage,
            ScenarioContext scenario
    ){

        Given("User is on homepage", () -> {
            homePage.navigateToHomePage();
        });

    }

}
