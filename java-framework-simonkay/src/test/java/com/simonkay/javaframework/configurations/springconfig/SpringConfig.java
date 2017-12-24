package com.simonkay.javaframework.configurations.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.simonkay.javaframework.configurations.CucumberWorld;
import com.simonkay.javaframework.configurations.FrameworkProperties;
import com.simonkay.javaframework.configurations.webdriver.Driver;
import com.simonkay.javaframework.pageobjects.PuppyAdoptionHomePage;
import com.simonkay.javaframework.utility.exceptions.InvalidDriverTypeSelectedException;

@Configuration
@PropertySource(value = {"classpath:/framework.properties"})
public class SpringConfig {


	@Bean
	public CucumberWorld cucumberWorld() {
		return new CucumberWorld();
	}

	@Bean(destroyMethod = "quit")
	@Scope("singleton")
	public Driver driver() {
		Driver wd = null;
		try {
		wd = new Driver(properties().getBrowserType());
		} catch(InvalidDriverTypeSelectedException ex) {
			System.out.println("Invalid driver specified" + ex);
			System.exit(1);
		}
		return wd;
	}

	@Bean
	public FrameworkProperties properties() {
		return new FrameworkProperties();
	}

	@Bean
    public PuppyAdoptionHomePage bingSearchPage() {
        return new PuppyAdoptionHomePage(
                driver(),               
                properties().seleniumImplicitWaitTime(),
                properties().getTestServerBaseAddress()
        );
    }
	
	
}
