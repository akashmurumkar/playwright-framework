package com.autoramming.cucumber.stepDefinitions;

import com.autoramming.cucumber.runners.RunnerTest;
import com.autoramming.practice.DriverFactory;
import com.autoramming.practice.PlaywrightUtil;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Steps extends RunnerTest {

    Page page;

    public Steps() {
        log.info("Invoked step definitions constructor.");
//        page = PlaywrightUtil.getPage();
    }

    @Given("user launches the application with {string}")
    public void user_launches_the_application(String url) {
        PlaywrightUtil.getPage().navigate(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("enters username {string} and password {string}")
    public void enters_username_and_password(String username, String password) {
    }

    @When("signs in the application")
    public void signs_in_the_application() {
    }

    @Then("sees successful login to the application")
    public void sees_successful_login_to_the_application() {
    }

}
