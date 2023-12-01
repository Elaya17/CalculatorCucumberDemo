package com.test.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HelperClass {

	public static AppiumDriver<MobileElement> androidDriver;

	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		ConfigFileReader cFileReader = new ConfigFileReader();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", cFileReader.getDeviceName());
		capabilities.setCapability("platformVersion", cFileReader.getPlatformVersion());
		capabilities.setCapability("app", System.getProperty("user.dir") + cFileReader.getAppPath());
		capabilities.setCapability("platformName", cFileReader.getPlatformName());
		androidDriver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		return androidDriver;

	}

	public static void tapElement(MobileElement element) {
		FluentWait<WebDriver> waits = new WebDriverWait(androidDriver, 60).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		waits.until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed() == true) {
			element.click();

		}
	}

	public static void enterText(MobileElement element, String text) {
		FluentWait<WebDriver> waits = new WebDriverWait(androidDriver, 60).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		waits.until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed() == true) {
			element.sendKeys(text);
		}

	}

	public static String getTextValue(MobileElement element) {
		String text = null;
		FluentWait<WebDriver> waits = new WebDriverWait(androidDriver, 60).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		waits.until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed() == true) {
			text = element.getText();
			System.out.println(text);
		}

		return text;

	}

	public static void assertVerificationBoolean(MobileElement element) {
		FluentWait<WebDriver> waits = new WebDriverWait(androidDriver, 60).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		waits.until(ExpectedConditions.visibilityOf(element));
		boolean isAvailable = element.isDisplayed();
		Assert.assertEquals(true, isAvailable);

	}

	public static void assertVerificationString(String expected, String actual) {

		Assert.assertEquals(actual, expected);

	}

	public static void closeDriver() {
		androidDriver.quit();
	}
}
