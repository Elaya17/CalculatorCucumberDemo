package com.test.pages;
import org.openqa.selenium.support.PageFactory;

import com.test.utilities.HelperClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculationPage extends HelperClass {

	public CalculationPage(AppiumDriver<MobileElement> anroidDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);

	}

	public static CalculationPage calculationPage = new CalculationPage(androidDriver);

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
	private MobileElement btnOptions;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
	private MobileElement btnChooseTheme;

	@AndroidFindBy(xpath = "(//*[@resource-id='android:id/text1'])[2]")
	private MobileElement btnDarkTheme;

	@AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
	private MobileElement btnOk;

	@AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
	private MobileElement btnDigit4;

	@AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
	private MobileElement btnDigit9;

	@AndroidFindBy(id = "com.google.android.calculator:id/op_pct")
	private MobileElement btnPercentage;

	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
	private MobileElement btnMultiplication;

	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	private MobileElement btnEqual;

	@AndroidFindBy(xpath = "(//*[@resource-id	='com.google.android.calculator:id/title'])[1]")
	private MobileElement btnHistory;

	@AndroidFindBy(id = "com.google.android.calculator:id/history_formula")
	private MobileElement txtFormulaHistory;

	@AndroidFindBy(id = "com.google.android.calculator:id/history_result")
	private MobileElement txtResultsHistory;

	@AndroidFindBy(id = "com.google.android.calculator:id/formula")
	private MobileElement txtFormulaField;

	public MobileElement getBtnOptions() {
		return btnOptions;
	}

	public MobileElement getBtnChooseTheme() {
		return btnChooseTheme;
	}

	public MobileElement getBtnDarkTheme() {
		return btnDarkTheme;
	}

	public MobileElement getBtnOk() {
		return btnOk;
	}

	public MobileElement getBtnDigit4() {
		return btnDigit4;
	}

	public MobileElement getBtnDigit9() {
		return btnDigit9;
	}

	public MobileElement getBtnPercentage() {
		return btnPercentage;
	}

	public MobileElement getBtnMultiplication() {
		return btnMultiplication;
	}

	public MobileElement getBtnEqual() {
		return btnEqual;
	}

	public MobileElement getBtnHistory() {
		return btnHistory;
	}

	public MobileElement getTxtFormulaHistory() {
		return txtFormulaHistory;
	}

	public MobileElement getTxtResultsHistory() {
		return txtResultsHistory;
	}

	public MobileElement getTxtFormulaField() {
		return txtFormulaField;
	}

	public static void tapChooseTheme() {

		tapElement(calculationPage.getBtnChooseTheme());

	}

	public static void tapDarkTheme() {
		tapElement(calculationPage.getBtnDarkTheme());

	}

	public static void tapOkButton() {
		tapElement(calculationPage.getBtnOk());

	}

	public static void verifyUserisOnCalculationPage() {
		assertVerificationBoolean(calculationPage.getTxtFormulaField());

	}

	public void tapMoreOptions() {

		tapElement(calculationPage.getBtnOptions());

	}

	public void tapOnMultiplication() {
		tapElement(calculationPage.getBtnMultiplication());

	}

	public void tapOnDigit4() {
		tapElement(calculationPage.getBtnDigit4());

	}

	public void tapOnDigit9() {
		tapElement(calculationPage.getBtnDigit9());

	}

	public void tapOnEqual() {
		tapElement(calculationPage.getBtnEqual());

	}

	public void tapOnHistory() {
		tapElement(calculationPage.getBtnHistory());

	}

	public String getTextValueInHistory() {
		String inputValue = getTextValue(calculationPage.getTxtFormulaHistory());
		return inputValue;

	}

	public String getTextValueInResult() {
		String resultValue = getTextValue(calculationPage.getTxtResultsHistory());
		return resultValue;

	}

	public void enterValueInCalculator(Integer int1) {
		enterText(calculationPage.getTxtFormulaField(), int1.toString());

	}

}
