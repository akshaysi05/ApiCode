package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature",plugin="json:target/jsonReports/cucumber-report.json",glue = {"stepDefination"})  //,tags = "@DeletePlace"
public class TestRunner {

}


