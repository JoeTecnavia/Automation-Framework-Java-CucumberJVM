#Sample Feature Definition Template
@tag


Feature: Bing Search 001
	As a simple internet user
	I want to search bing for results
	So that I can waste time browsing randomness

	@issue=007 @tmsLink=008 @severity=critical @flaky
  Scenario: Simple interaction with a web page 001
  	This is a simple description
  	
    Given I am on the bing search page
    When I search for "symonk github"
		Then I can see my results