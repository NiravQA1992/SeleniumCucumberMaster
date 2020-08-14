package com.test.step.defintions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		// pretty:target/cucumber-json-report.json
		features = "classpath:features")

public class RunCukesTest {

	/*
	 * public static void writeExtentReport() {
	 * Reporter.loadXMLConfig("src/extent-config.xml"); }
	 */
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("src/extent-config.xml");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Application Name", "Salesforce CRM");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "QA");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		Reporter.setSystemInfo("Selenium", "3.11.0");
		Reporter.setSystemInfo("Maven", "3.7.0");
		Reporter.setSystemInfo("Java Version", "1.8.0_231");
	}
}
