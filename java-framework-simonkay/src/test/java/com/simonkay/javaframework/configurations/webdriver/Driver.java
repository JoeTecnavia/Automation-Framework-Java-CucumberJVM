package com.simonkay.javaframework.configurations.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Driver extends EventFiringWebDriver {

	private static WebDriver CURRENT_DRIVER;


	private static final Thread SHUTDOWN_HOOK = new Thread() {
		@Override
		public void run() {
			killDriver();
		}
	};
	
	 @Override
	    public void close() {
	        if (Thread.currentThread() != SHUTDOWN_HOOK) {
	            throw new UnsupportedOperationException("Driver will close when the JVM exits, do not manually call .close() on it");
	        }
	        try {
	            super.close();
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	    }
	 
	public static void killDriver() {
		WebDriver driver = CURRENT_DRIVER;
		CURRENT_DRIVER = null;
		if (driver != null) {
			driver.quit();
		}
	}

	public Driver() {
		super(getCurrentDriver());
		Runtime.getRuntime().addShutdownHook(SHUTDOWN_HOOK);

	}

	private static WebDriver getCurrentDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver.exe");
		return new ChromeDriver();
		
	}

}
