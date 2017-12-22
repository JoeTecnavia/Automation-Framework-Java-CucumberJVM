package com.simonkay.javaframework.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.simonkay.javaframework.configurations.CucumberWorld;
import com.simonkay.javaframework.configurations.springconfig.SpringConfig;

import cucumber.api.Scenario;

@ContextConfiguration(classes = SpringConfig.class)
public abstract class AbstractBaseStepDefinition {

	protected Scenario scenario;

	@Autowired
	protected CucumberWorld cucumberWorld;

	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	protected void embedTextInReport(String text) {
		scenario.write(text);
	}

}
