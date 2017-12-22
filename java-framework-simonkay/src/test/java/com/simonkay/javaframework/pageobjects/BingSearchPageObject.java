package com.simonkay.javaframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPageObject extends AbstractBasePageObject {

	private static final String relativePath = "/";
	@FindBy(name = "q")
	private WebElement searchTextBox;

	public BingSearchPageObject(WebDriver driver, int implicitWait, String url) {
		super(driver, implicitWait, url + relativePath);
		PageFactory.initElements(driver, this);
	}

	public void search(String searchText) {
		set_text(searchTextBox, searchText);
		submit(searchTextBox);
	}
	
	public boolean isSearchResultPresent(String result) { 
		return is_text_present(result);
	}
	

	@Override
	protected void load() {
		

	}

	@Override
	protected void isLoaded() throws Error {
		

	}

}
