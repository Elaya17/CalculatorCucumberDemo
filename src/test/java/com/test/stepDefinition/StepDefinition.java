package com.test.stepDefinition;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.test.pages.CalculationPage;
import com.test.utilities.HelperClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.TestNGCucumberRunner;

public class StepDefinition extends HelperClass {
	public static AppiumDriver<MobileElement> androidDriver;
	public static CalculationPage cPage;
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}

	@Given("Launch the app")
	public void launch_the_app() throws MalformedURLException {
		androidDriver = getAndroidDriver();
		cPage = new CalculationPage(androidDriver);

	}

	@When("Click on moreoptions button in the top right corner")
	public void click_on_moreoptions_button_in_the_top_right_corner() throws MalformedURLException {

		cPage.tapMoreOptions();

	}

	@When("Click on choose theme button")
	public void click_on_choose_them_button() {
		cPage.tapChooseTheme();

	}

	@When("Click on Light button")
	public void click_on_light_button() {
		cPage.tapDarkTheme();

	}

	@When("Click on OK button")
	public void click_on_ok_button() {
		cPage.tapOkButton();

	}

	@Then("Verify user is in calculation page")
	public void verify_user_is_in_calculation_page() {
		cPage.verifyUserisOnCalculationPage();

	}

	@When("Enter the value\"{int}\" in the calculator")
	public void enter_the_value_in_the_calculator(Integer int1) throws InterruptedException {
		Thread.sleep(5000);
		cPage.enterValueInCalculator(int1);

	}

	@When("Tap on multiplication icon")
	public void tap_on_multiplication_icon() {
		cPage.tapOnMultiplication();

	}

	@When("Tap on digit nine")
	public void tap_on_digit_nine() {
		cPage.tapOnDigit9();

	}

	@When("Click on Equal icon")
	public void click_on_Equal_icon() {
		cPage.tapOnEqual();

	}

	@When("Click on History button")
	public void click_on_History_button() {
		cPage.tapOnHistory();

	}

	@Then("Verify input and results")
	public void verify_input_and_results() {
		String textValueInResult = cPage.getTextValueInResult();
		assertVerificationString("54", textValueInResult);
	}

	@Then("Close App")
	public void close_App() {
		closeDriver();

	}

}
