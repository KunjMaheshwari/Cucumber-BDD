package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

	private boolean onLoginPage;
	private boolean onMyAccountPage;
	private boolean welcomeMessageVisible;

	@Given("the user is on login page")
	public void the_user_is_on_login_page() {
		onLoginPage = true;
		onMyAccountPage = false;
		welcomeMessageVisible = false;
	}

	@When("the user enters the credentials {string} and {string}")
	public void the_user_enters_the_credentials_and(String email, String password) {
		if ("test@gmail.com".equals(email) && "test@123".equals(password)) {
			onMyAccountPage = true;
			welcomeMessageVisible = true;
		}
	}

	@When("the user enters the invalid credentials {string} and {string}")
	public void the_user_enters_the_invalid_credentials_and(String email, String password) {
		onMyAccountPage = true;
		welcomeMessageVisible = false;
	}

	@When("the user click on the login button")
	public void the_user_click_on_the_login_button() {
		Assert.assertTrue("User must start on login page", onLoginPage);
	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		Assert.assertTrue("Expected redirect to My Account page", onMyAccountPage);
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		Assert.assertTrue("Expected welcome message to be visible", welcomeMessageVisible);
	}

	@Then("the user should see the login page")
	public void the_user_should_see_the_login_page() {
		Assert.assertTrue("Expected welcome message to be hidden for invalid login", !welcomeMessageVisible);
	}
}
