package TestRunnerBlock;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/main/java/FeatureFiles/AddNewCustmer.feature",
				 glue="StepDefinationBlock",
				 dryRun = false)
public class AddNewCustomer extends AbstractTestNGCucumberTests{


}
