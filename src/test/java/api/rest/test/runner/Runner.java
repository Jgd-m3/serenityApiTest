package api.rest.test.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        glue = {"api.rest.test.gherkinDefinitions"},
        tags = {"@start_this"}

        //in runTest>config>Arguments : -Dcucumber.options="--tags @test"
)

public class Runner {
}
