package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.swopper.Utils.ConfigReader;
import com.swopper.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader congifReader;
	static Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		
		congifReader=new ConfigReader();
		prop= congifReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName=prop.getProperty("browser");
		driverFactory= new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}
	
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot
			String screenshotName= scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
		}
		
	}
	
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	public static Properties getProp() {
		
		return prop;
	}
	
	
}
