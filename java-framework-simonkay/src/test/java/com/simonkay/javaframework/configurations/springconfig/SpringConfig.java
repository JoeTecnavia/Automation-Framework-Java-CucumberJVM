package com.simonkay.javaframework.configurations.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.simonkay.javaframework.configurations.CucumberWorld;
import com.simonkay.javaframework.configurations.FrameworkProperties;
import com.simonkay.javaframework.configurations.webdriver.Driver;
import com.simonkay.javaframework.pageobjects.BingSearchPageObject;

@Configuration
@PropertySource(value = {"classpath:/framework.properties"})
public class SpringConfig {

	//Inversion of control beans
	@Bean
	public CucumberWorld cucumberWorld() {
		return new CucumberWorld();
	}

	@Bean
	public Driver driver() {
		return new Driver();
	}

	@Bean
	public FrameworkProperties properties() {
		return new FrameworkProperties();
	}

	//Setup Bean for page objects here =>
	
	@Bean
    public BingSearchPageObject bingSearchPage() {
        return new BingSearchPageObject(
                driver(),               
                properties().seleniumImplicitWaitTime(),
                properties().getTestServerBaseAddress()
        );
    }
	
	
}
