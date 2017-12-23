package com.simonkay.javaframework.configurations.webdriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverHooks {

	@Autowired
	private Driver driver;


	@Before
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@After
	public void screenshotAndPageSourceOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
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
