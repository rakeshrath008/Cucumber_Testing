package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features\\Login_Page.feature" ,
		           //features = "Features/Tagging.feature",
		           //features="Features/Setup_Teardown.feature",
                   glue = "demo",
                   plugin = {"pretty","html:target/cucumber-reports/report.html"},
                  dryRun = false,
                  monochrome = true
                  //tags = "@RegressionTest or @SanityTest"
                  //tags = "@RegressionTest and @End2End"
                  //tags = "not @End2End" 
		           )
public class TestRunner 
{
	
}
