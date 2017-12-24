package com.simonkay.javaframework.configurations;

import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CucumberWorld {
	private static final Logger LOG = LogManager.getLogger(CucumberWorld.class);
	
	public HashMap<String, String> stepDefinitionState = new HashMap<String, String>();
	
}
