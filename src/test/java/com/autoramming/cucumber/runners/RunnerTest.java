package com.autoramming.cucumber.runners;

import com.autoramming.practice.Config;
import com.autoramming.practice.DriverFactory;
import com.autoramming.practice.PlaywrightUtil;
import io.cucumber.java.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@CucumberOptions(
        features = {
                "src/test/resources/features"
        },
        glue = "com.autoramming.cucumber.stepDefinitions",
        tags = "@login",
        plugin = {
                "usage:target/cucumber/usage.json", // provides time taken for features running
                "pretty", // shows passed feature steps
                "junit:target/cucumber/cucumber.xml",
                "json:target/cucumber/output.json",
                "html:target/cucumber/report.html",
                "testng:target/cucumber/testng.xml"
        },
        dryRun = false,
        monochrome = false,
        publish = false // publishes reports to shared server - reports.cucumber.io
)
@Slf4j
public class RunnerTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    @Parameters({"browser"})
    public void defineBrowser(String browser) {
        log.info("Before Class: " + browser);
        PlaywrightUtil.setPage(browser);
    }

    @AfterMethod
    public void closeBrowser() {
       PlaywrightUtil.closePage();
    }

}
