package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\features\\feature1.feature", 
		plugin = { "pretty","html:target/cucumber/report.html" }, 
		glue = "MethodImplementation", 
		dryRun = false, 
		monochrome = true)

public class RunnerClass {

}
