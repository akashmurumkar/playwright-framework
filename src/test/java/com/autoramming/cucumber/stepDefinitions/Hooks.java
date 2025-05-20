package com.autoramming.cucumber.stepDefinitions;

import io.cucumber.java.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    @BeforeAll
    public static void init() {
        log.info("Before All: Inside initializer!");
    }

    @Before
    public void setupExecution(Scenario scenario) {
        log.info("Before: Inside execution setup!");
        log.info("Before: Executing scenario: " + scenario.getName());
    }

    @BeforeStep
    public void beforeEachStep() {
        log.info("Before Step: Inside before step configuration!");
    }

    @AfterStep
    public void afterEachStep() {
        log.info("After Step: Inside after step configuration!");
    }

    @After
    public void tearDownExecution() {
        log.info("After: Inside execution completion!");
    }

    @AfterAll
    public static void flush() {
        log.info("After All: Inside flusher!");
    }

}
