package com.simonkay.javaframework.configurations.webdriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void screenShotOnFailure(Scenario scenario) {
		if (!(scenario.isFailed())) {
			try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                if (driver.getWrappedDriver() instanceof TakesScreenshot) {
                    byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                }
            } catch (Throwable somePlatformsDontSupportScreenshotsOrBrowserHasDied) {
                somePlatformsDontSupportScreenshotsOrBrowserHasDied.printStackTrace(System.err);
            }
		}
	}
	
}
