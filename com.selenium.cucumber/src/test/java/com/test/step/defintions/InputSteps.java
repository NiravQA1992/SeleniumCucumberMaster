package com.test.step.defintions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.selenium.configure.environment.PropertiesHandler;
import com.test.valueprovider.FullNameProvder;

import cucumber.api.java.en.When;

/**
 * This class contains methods to allow you input into a field. More steps
 * examples here:
 * https://github.com/NiravQA1992/SeleniumCucumberMaster/blob/master/com.selenium.cucumber/doc/canned_steps.md
 * 
 * @author Nirav Panchal
 */
public class InputSteps {
	WebDriver driver;

	/******** Log Attribute ********/
	private static Logger log = Logger.getLogger(InputSteps.class);

	public InputSteps() {
		driver = Hooks.driver;
	}

	/** Enter a text into an input field element. */
	@When("^the user enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void inputText(String text, String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		WebElement input = driver.findElement(element);
		input.click();
		input.clear();
		log.info("Sending text: " + text + "into element" + element);
		input.sendKeys(text);
	}

	@When("^the user enter Random Name into input field having (.+) \"([^\"]*)\"$")
	public void inputRandomText(String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		WebElement input = driver.findElement(element);
		input.click();
		input.clear();
		FullNameProvder provider = new FullNameProvder();
		String RandomName = provider.CreateName();
		log.info("Sending text: " + RandomName + "into element" + element);
		input.sendKeys(RandomName);
	}

	/** Enter a text into an input field element slowly */
	@When("^the user slowly enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void slowSendKeys(String text, String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		WebElement input = driver.findElement(element);
		input.click();
		for (char c : text.toCharArray()) {
			ProgressSteps.wait(5);
			input.sendKeys("" + c);
		}
	}

	/** Clear input field element. */
	@When("^the user clear input field having (.+) \"([^\"]*)\"$")
	public void clearText(String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		WebElement input = driver.findElement(element);
		input.click();
		input.clear();
		log.info("Element: " + element + "clear");

	}

	/** Select an option by text/value from a drop-down */
	@When("^the user select \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
	public void selectOptionDropdown(String option, String optionBy, String type, String key) throws Exception {
		By dropdown = PropertiesHandler.getCompleteElement(type, key);
		Select opt = new Select(driver.findElement(dropdown));

		if (optionBy.equals("text")) {
			log.info("Select option: " + option + "by text");
			opt.selectByVisibleText(option);
		} else if (optionBy.equals("value")) {
			log.info("Select option: " + option + "by value");
			opt.selectByValue(option);

		}
	}

	/** Select an option by index from a drop-down */
	@When("^the user select option (\\d+) by index from dropdown having (.+) \"(.*?)\"$")
	public void selectOptionDropdownByIndex(int option, String type, String key) throws Exception {
		By dropdown = PropertiesHandler.getCompleteElement(type, key);
		Select opt = new Select(driver.findElement(dropdown));
		log.info("Select option: " + option + "by text");
		opt.selectByIndex(option);
	}

	/** Clear all options selected from a drop-down */
	@When("^the user clear all options selected from dropdown having (.+) \"(.*?)\"$")
	public void deselectAllOptionDropdown(String type, String key) throws Exception {
		By dropdown = PropertiesHandler.getCompleteElement(type, key);
		Select opt = new Select(driver.findElement(dropdown));
		log.info("Clear all options selected from drop-down");
		opt.deselectAll();
	}

	/** Unselect an option by text/value from a drop-down */
	@When("^the user unselect \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
	public void unselectOptionMultiDropdown(String option, String optionBy, String type, String key) throws Exception {
		By dropdown = PropertiesHandler.getCompleteElement(type, key);
		Select opt = new Select(driver.findElement(dropdown));

		if (optionBy.equals("text")) {
			log.info("Unselect option: " + option + "by text");
			opt.deselectByVisibleText(option);
		} else if (optionBy.equals("value")) {
			log.info("Unselect option: " + option + "by value");
			opt.deselectByValue(option);
		}
	}

	/** Unselect an option by index from a drop-down */
	@When("^the user unselect (\\d+) option by index from dropdown having (.+) \"(.*?)\"$")
	public void unselectOptionMultiDropdownByIndex(int option, String type, String key) throws Exception {
		By dropdown = PropertiesHandler.getCompleteElement(type, key);
		Select opt = new Select(driver.findElement(dropdown));
		log.info("Select option: " + option + "by text");
		opt.selectByIndex(option);
	}

	/** Check an option from a checkbox */
	@When("^the user check the checkbox having (.+) \"(.*?)\"$")
	public void checkCheckbox(String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		boolean isChecked = driver.findElement(element).isSelected();
		if (!isChecked) {
			log.info("Clicking on the checkbox to select:" + element);
			driver.findElement(element).click();
		}
	}

	/** Uncheck an option from a checkbox */
	@When("^the user uncheck the checkbox having (.+) \"(.*?)\"$")
	public void uncheckCheckbox(String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		boolean isChecked = driver.findElement(element).isSelected();
		if (isChecked) {
			log.info("Clicking on the checkbox to uncheck:" + element);
			driver.findElement(element).click();
		}
	}

	/** Select a radio button */
	@When("^the user select radio button having (.+) \"(.*?)\"$")
	public void selectRadioButton(String type, String key) throws Exception {
		By element = PropertiesHandler.getCompleteElement(type, key);
		boolean isSelected = driver.findElement(element).isSelected();
		if (!isSelected) {
			log.info("Clicking on the radio button to select:" + element);
			driver.findElement(element).click();
		}

	}
}
