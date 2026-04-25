package stepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        System.out.println("User is on login page");
    }

    @When("the user enters the credentials {string} and {string}")
    public void the_user_enters_the_credentials_and(String username, String password) {
        System.out.println("Valid: " + username + " " + password);
    }

    @When("the user enters the invalid credentials {string} and {string}")
    public void the_user_enters_the_invalid_credentials_and(String username, String password) {
        System.out.println("Invalid: " + username + " " + password);
    }

    @When("the user click on the login button")
    public void the_user_click_on_the_login_button() {
        System.out.println("Clicked login");
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        System.out.println("Redirected to account page");
    }

    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        System.out.println("Welcome message displayed");
    }

    @Then("the user should see the login page")
    public void the_user_should_see_the_login_page() {
        System.out.println("Login page displayed again");
    }
}