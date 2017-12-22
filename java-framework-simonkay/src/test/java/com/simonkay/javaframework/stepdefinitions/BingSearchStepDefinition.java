package com.simonkay.javaframework.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import com.simonkay.javaframework.pageobjects.BingSearchPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class BingSearchStepDefinition extends AbstractBaseStepDefinition {

	@Autowired
	private BingSearchPageObject bingSearchPage;

	@Before
	public void before(Scenario scenario) {
		super.before(scenario);
	}

	@Given("^I am on the bing search page$")
	public void i_am_on_the_bing_search_page() throws Throwable {
		bingSearchPage.navigate_and_wait();
	}

	@When("^I search for \"(.+)\"$")
	public void I_search_for(String searchText) throws Throwable {
		bingSearchPage.search(searchText);
	}

	@Then("^The site \"([^\"]*)\" should be in the results$")
	public void the_site_should_be_in_the_results(String resultUrl) throws Throwable {
		//assertThat(bingSearchPage.isSearchResultPresent(resultUrl)).isTrue(); //This will pass :)
		assertThat(false).isTrue(); //This will fail of course :)
	}

}
