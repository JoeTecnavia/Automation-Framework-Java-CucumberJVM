package com.simonkay.javaframework.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import datamodels.Order;
import dataproviders.DataProviderInjector;

public class GeneralSteps extends AbstractBaseStepDefinition {
	
	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}
	
	@Given("^The order \"([^\"]*)\" exists$")
	public void the_order_exists(String orderAlias) throws Throwable {
		Order order = new Order("Credit card", new DataProviderInjector());
		cucumberWorld.addNewOrder(orderAlias, order);    
	}


}
