package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/featureFiles",
					glue= {"stepDefinitions", "hooks"},
				//	plugin= {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"
					plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
							
							,
					monochrome=true,
					publish= true  //to get the cucumber report on cucumber cloud
				//	tags= "@SmokeTest or @All"   //not @Smoke will ignore smoke tag once
	
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][]scenarios(){
		return super.scenarios();
		
	}

}
