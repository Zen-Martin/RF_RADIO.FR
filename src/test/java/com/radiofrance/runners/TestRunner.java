package com.radiofrance.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        features = {"src/test/resources"},
        glue = {"com.radiofrance.steps.test", "com/radiofrance/pageObjects"}
)
public class TestRunner extends BaseRunner{
}
