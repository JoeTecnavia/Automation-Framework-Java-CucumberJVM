import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/simon/Desktop/java-selenium-parallel-framework/java-framework-simonkay/src/test/resources/features/Bingsearch.feature:6"},
        plugin = {"json:C:/Users/simon/Desktop/java-selenium-parallel-framework/java-framework-simonkay/target/cucumber-parallel/1.json"},
        monochrome = true,
        glue = {"com.simonkay.javaframework.stepdefinitions"})
public class Parallel01IT {
}
