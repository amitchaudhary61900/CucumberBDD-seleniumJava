package stepDefinitions;

import java.util.Properties;

import org.testng.Assert;

import com.swopper.factory.DriverFactory;
import com.swopper.pages.LoginPage;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private Properties prop= Hooks.getProp() ;
	
	
	@Given("User is on the swopper admin login page")
	public void user_is_on_the_swopper_admin_login_page() {
		
		DriverFactory.getDriver().get(prop.getProperty("baseURL"));
		
	}

	@Given("I have entered a valid {string} and {string}")
	public void i_have_entered_a_valid_and(String username, String password) {
		loginpage.enterEmail(username);
		loginpage.enterPassword(password);
		
	   
	}

	@When("I clicked on login button")
	public void i_clicked_on_login_button() throws InterruptedException {
		loginpage.loginButton();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		String expected=loginpage.assertUsingLogoutButton();
		Assert.assertEquals(expected, "Logout");
	}
	
	@Then("I should get error toast")
	public void i_should_get_error_toast() {
		String expected=loginpage.assertWhileInvalidCred();
		Assert.assertEquals(expected, "Login failed");
	}
	
	

}
