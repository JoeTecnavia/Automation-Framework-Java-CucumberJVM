package com.simonkay.javaframework.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class FrameworkProperties {

    @Autowired
    private Environment environment;
    
    public String getTestServerBaseAddress() {
    	return environment.getProperty("env.baseurl");
    }
    
    public String getGridAddress() {
    	return environment.getProperty("grid.endpoint");
    }
    
    public String getGridOrLocal() {
    	return environment.getProperty("run.on.grid");
    }
    
    public String getBrowserType() {
    	return environment.getProperty("browser");
    }
    
    public String getPlatformType() {
    	return environment.getProperty("platform");
    }
    
    public int seleniumImplicitWaitTime() {
    	return environment.getProperty("driver.implicit.wait", Integer.class);
    }
    
    
}
