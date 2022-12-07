package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="@FailedScenarios/failed_scenarios.txt",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true
		)
public class ReRunner {


}
