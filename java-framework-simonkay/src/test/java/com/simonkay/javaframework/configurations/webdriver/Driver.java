package com.simonkay.javaframework.configurations.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.simonkay.javaframework.utility.InvalidDriverTypeSelectedException;

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

	public Driver(String browserType) throws InvalidDriverTypeSelectedException {
		super(getCurrentDriver(browserType));
		Runtime.getRuntime().addShutdownHook(SHUTDOWN_HOOK);
	}

	private static WebDriver getCurrentDriver(String browserType) throws InvalidDriverTypeSelectedException {
		switch(browserType.toLowerCase()) {
		case "chrome":  System.setProperty("webdriver.chrome.driver", "src/test/resources/binaries/chromedriver.exe");
					    return new ChromeDriver();
		case "firefox": System.setProperty("webdriver.firefox.driver", "src/test/resources/binaries/geckodriver.exe");
					    return new FirefoxDriver();
		default: 		throw new InvalidDriverTypeSelectedException("Invalid driver specified, enter: 'chrome' or 'firefox' in the "
				+ "resources/framework.properties file, this can be passed at runtime using mvn -D arguments");					
		}
					   
	}

}
