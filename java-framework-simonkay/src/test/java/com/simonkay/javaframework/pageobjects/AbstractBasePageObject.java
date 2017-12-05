package com.simonkay.javaframework.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePageObject {
	private final WebDriver driver;
	private final int timeToWait;
	private final WebDriverWait wait;
	private final String url;

	public AbstractBasePageObject(WebDriver driver, int implicitWait, String url) {
		this.driver = driver;
		timeToWait = implicitWait;
		wait = new WebDriverWait(getDriver(), timeToWait);
		this.url = url;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public boolean does_element_exist(By loc) {
		return driver.findElements(loc).size() != 0 ? true : false;
	}
	
	public void navigate_and_wait() {
		driver.get(url);
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public void set_text(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}

	public void submit(WebElement ele) {
		ele.submit();
	}

	public void selectDropDownByValue(WebElement ele, String valueToChoose) {
		 Select s = new Select(ele);
		 wait_for_dropdown(ele);
		 s.selectByVisibleText(valueToChoose);
	}


	private void wait_for_dropdown(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	protected WebElement find(By loc) {
        try {
            return getDriver().findElement(loc);
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(ex.getMessage() + "\n\nPageSource:\n\n" + getDriver().getPageSource());
        }
    }

}
