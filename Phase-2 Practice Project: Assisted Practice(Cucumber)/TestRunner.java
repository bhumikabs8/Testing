package in.amazon.teststeps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features",
		glue = "in.amazon.teststeps"
		//dryRun = true
		//tags = "@TC_101"
		//tags = "@TC_101 or @TC_102"
		//tags = "@product_purchase or @login_functionality"
		//tags = "@login_functionality and @TC_103"
		)

public class TestRunner extends AbstractTestNGCucumberTests
{
	
}