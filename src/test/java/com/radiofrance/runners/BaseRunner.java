package com.radiofrance.runners;

import com.radiofrance.config.Properties;
import com.google.common.collect.ImmutableMap;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseRunner extends AbstractTestNGCucumberTests {


    @Parameters({"browser", "device"})
    @BeforeClass
    public static void beforeTest(@Optional String browser, @Optional String device){
        String browserA;

        browserA = java.util.Optional
                .ofNullable(browser)
                .orElse(Properties.Config.getBrowser());

        Properties.DriverManager.setDriver(browserA);

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("URL", "https://www.cdiscount.com")
                        .put("Browser", "Chrome")
                        .build(),System.getProperty("user.dir")
                        + "/allure-results/");
    }

    @AfterClass
    public static void tearDown(){
        Properties.DriverManager.getDriver().quit();
    }

}
