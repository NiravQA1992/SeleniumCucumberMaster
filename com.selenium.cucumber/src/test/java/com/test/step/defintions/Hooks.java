package com.test.step.defintions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.selenium.configure.environment.CreateDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static WebDriver driver;
	Logger log = Logger.getLogger(Hooks.class);
	Scenario scenario = null;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		Reporter.assignAuthor("Senir Automation Engineer - Nirav Panchal");
	}

	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid shared state
	 * between tests
	 */
	public void initDriver() throws MalformedURLException {
		log.info(
				"***********************************************************************************************************");
		log.info("[ Configuration ] - Initializing driver configuration");
		log.info(
				"***********************************************************************************************************");
		driver = CreateDriver.initConfig();

		log.info(
				"***********************************************************************************************************");
		log.info("[ Scenario ] - " + scenario.getName());
		log.info(
				"***********************************************************************************************************");
	}

	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			try {
				scenario.write("The scenario failed.");
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "resources/screenshot");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
				String screenShotName = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + dateFormat.format(GregorianCalendar.getInstance().getTime());
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				log.info("Screenshot saved as:" + screenShotName);
				FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenShotName)));
				
				//File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenShotName + ".png");
				
				Reporter.addScreenCaptureFromPath(String.format("%s.png", screenShotName).toString());
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}

		log.info(
				"***********************************************************************************************************");
		log.info("[ Driver Status ] - Clean and close the intance of the driver");
		log.info(
				"***********************************************************************************************************");
		driver.quit();

	}
}
