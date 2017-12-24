package com.simonkay.javaframework.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.simonkay.javaframework.pageobjects.PuppyAdoptionHomePage;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class PuppyAdoptionSteps extends AbstractBaseStepDefinition {
	private static final Logger LOG = LogManager.getLogger(PuppyAdoptionSteps.class);

	@Autowired
	private PuppyAdoptionHomePage puppyAdoptionHomePage;

	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
		puppyAdoptionHomePage.navigate_and_wait();
	}

	@When("^I adopt a puppy providing \"([^\"]*)\"$")
	public void i_adopt_a_puppy_providing(String orderAlias) throws Throwable {
		LOG.debug("Attempting to adopt a puppy using order" + orderAlias);
		puppyAdoptionHomePage.select_a_puppy();

	}

	@Then("^I should see the successful adoption message$")
	public void i_should_see_the_successful_adoption_message() throws Throwable {
		LOG.debug("Asserting the successful adoption message has appeared");

	}

}
