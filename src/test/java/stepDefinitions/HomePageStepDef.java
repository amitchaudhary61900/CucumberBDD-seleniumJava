package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.swopper.factory.DriverFactory;
import com.swopper.pages.HomePage;
import com.swopper.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class HomePageStepDef {

	private LoginPage loginpage= new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	
	@Given("Admin should be able to logged in to the application")
	public void admin_should_be_able_to_logged_in_to_the_application(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> credentials=dataTable.asMaps();
		String  username=credentials.get(0).get("username");
		String  password=credentials.get(0).get("password");
		
		DriverFactory.getDriver().get("http://3.105.68.11/");
		
		homepage=loginpage.doLogin(username, password);
	}

	@Given("Admin is on the homepage where page title is {string}")
	public void admin_is_on_the_homepage_where_page_title_is(String ExpecetdPageTitle) {
		String pageTitle=homepage.getHomePageTitle();
		Assert.assertEquals(pageTitle, ExpecetdPageTitle);
	}
	
}
