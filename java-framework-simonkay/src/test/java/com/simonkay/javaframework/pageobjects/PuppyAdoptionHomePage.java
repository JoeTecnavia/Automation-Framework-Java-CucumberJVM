package com.simonkay.javaframework.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PuppyAdoptionHomePage extends AbstractBasePageObject {
	private static final Logger LOG = LogManager.getLogger(PuppyAdoptionHomePage.class);

	private static final String relativePath = "/";
	@FindAll(value = { @FindBy(xpath = "") })
	private List<WebElement> viewDetailsButtons;
	
	@FindBy(id = "notice")
	private WebElement adoptionSuccessfulMessage;

	public PuppyAdoptionHomePage(WebDriver driver, int implicitWait, String url) {
		super(driver, implicitWait, url + relativePath);
		PageFactory.initElements(driver, this);
		LOG.info("Creating new BaseSearchPageObject, PageElements initialized!");
	}

	public void select_a_puppy() {
		LOG.debug("Attempting to select a puppy");
		viewDetailsButtons.get(2).click();
	}

	@Override
	protected void load() {
		LOG.info("LoadableComponent: Executing page onLoad");		

	}

	@Override
	protected void isLoaded() throws Error {
		LOG.info("LoadableComponent: Verifying isLoaded checks");
		

	}

}
