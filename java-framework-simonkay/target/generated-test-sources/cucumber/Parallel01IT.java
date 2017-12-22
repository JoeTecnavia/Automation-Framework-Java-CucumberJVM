import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/sy/Desktop/java-selenium-parallel-framework/java-framework-simonkay/src/test/resources/features/Bingsearch.feature:11"},
        plugin = {"json:C:/Users/sy/Desktop/java-selenium-parallel-framework/java-framework-simonkay/target/cucumber-parallel/1.json"},
        monochrome = true,
        glue = {"com.simonkay.javaframework.stepdefinitions"})
public class Parallel01IT {
}
