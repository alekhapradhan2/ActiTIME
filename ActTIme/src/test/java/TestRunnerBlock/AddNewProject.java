package TestRunnerBlock;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/main/java/FeatureFiles/AddNewProject.feature"
                ,glue = "StepDefinationBlock", dryRun = false
                  )

public class AddNewProject extends AbstractTestNGCucumberTests{
	

	

}
