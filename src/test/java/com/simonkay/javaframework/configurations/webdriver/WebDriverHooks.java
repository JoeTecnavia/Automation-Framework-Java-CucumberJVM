package com.simonkay.javaframework.configurations.webdriver;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

import com.simonkay.javaframework.utility.reporting.ReportEnvironmentHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverHooks {
	private static boolean runOnce = true;
	private static final Logger LOG = LogManager.getLogger(WebDriverHooks.class);
	
	@Autowired
	private Driver driver;
	
	@Autowired
	private ReportEnvironmentHelper rh;


	
	@Before
	public void logScenario(Scenario scenario) {
		LOG.debug("Beginning of scenario: " + scenario.getId());
	}
	
	@Before
	public void deleteCookies(Scenario scenario) {
		LOG.info("Deleting browser cookies after: " + scenario.getName());
		driver.manage().deleteAllCookies();
	}

	@After
	public void screenshotAndPageSourceOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			LOG.fatal("Failure in scenario: " + scenario.getName() + " capturing screenshot");
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				scenario.write(driver.getPageSource());
			} catch (WebDriverException wde) {
				System.err.println(wde
						.getMessage());
			}
		}
	}
	
	


}
