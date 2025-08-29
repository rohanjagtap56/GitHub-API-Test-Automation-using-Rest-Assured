package TestRunner;

import org.junit.runner.RunWith;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"StepDefinition","Hooks"},
		plugin = {"pretty","html:target/GithubReport.html"}
		)
public class GithubApiTestRunner{

}

//extends AbstractTestNGCucumberTests