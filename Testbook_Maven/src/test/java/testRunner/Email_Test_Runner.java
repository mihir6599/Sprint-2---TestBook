package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"FeatureFiles/Login/email.feature"} 					// which feature files to run
		,glue={"stepDefinition","base"}									//package names having the scripts for the feature file
		//,tags= {"@Testbook,@Valid_Email"}											// the tags to run.... which are in feature file		
		,tags= {"@Testbook,@Live_Classes"}
		)

public class Email_Test_Runner{
	
}
