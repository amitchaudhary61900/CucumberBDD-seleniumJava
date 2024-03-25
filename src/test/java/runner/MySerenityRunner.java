package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= "src/test/resources/featureFiles/LoginPage.feature",
					glue= {"stepDefinitions", "hooks"},
					plugin= {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"
							
							
							},
					monochrome=true,
					publish= true,  //to get the cucumber report on cucumber cloud
					tags= "@SmokeTest or @All"   //not @Smoke will ignore smoke tag once
	
		
		)

public class MySerenityRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][]scenarios(){
		return super.scenarios();
		
	}

}
