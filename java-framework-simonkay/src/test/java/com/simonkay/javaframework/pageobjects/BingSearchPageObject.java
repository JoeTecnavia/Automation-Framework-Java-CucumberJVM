package com.simonkay.javaframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BingSearchPageObject extends AbstractBasePageObject {
	
	public static final String relativePath = "/";
	private final By searchTextbox = By.name("q");
	
	public BingSearchPageObject(WebDriver driver, int implicitWait, String url) {
		super(driver, implicitWait, url + relativePath);
	}

	
	public void search(String searchText) {
        set_text(find(searchTextbox), searchText);
        submit(find(searchTextbox));
    }


}
