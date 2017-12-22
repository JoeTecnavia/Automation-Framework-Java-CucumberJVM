package com.simonkay.javaframework.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import com.simonkay.javaframework.pageobjects.BingSearchPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

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
    
}
