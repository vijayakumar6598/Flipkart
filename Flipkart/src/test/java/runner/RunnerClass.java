package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/Features",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"rerun:FailedScenarios/failed_scenarios.txt",
		"html:target/Flipkart-report/report.html"}

		)
public class RunnerClass {

}
