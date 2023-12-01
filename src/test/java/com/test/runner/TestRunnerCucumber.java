package com.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.test.stepDefinition" }, plugin = {
		"pretty", "html:cucumber-reports/cucumber.html",
		"json:cucumber-reports/report.json" }, monochrome = true)
public class TestRunnerCucumber extends AbstractTestNGCucumberTests {

}
