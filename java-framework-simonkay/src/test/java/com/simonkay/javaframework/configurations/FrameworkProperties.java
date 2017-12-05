package com.simonkay.javaframework.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class FrameworkProperties {

    @Autowired
    private Environment environment;
    
    public String getTestServerBaseAddress() {
    	return "https://www.bing.co.uk";
    }
    
    public String getParallelForkCount() {
    	return "";
    }
    
    public String getGridAddress() {
    	return "";
    }
    
    public String getBrowserType() {
    	return "";
    }
    
    public String getPlatformType() {
    	return "";
    }
    
    public int seleniumImplicitWaitTime() {
    	return 5;
    }
    
    
}
