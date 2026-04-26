package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    public WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://nocommerce.com/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Login']"))).click();
    }

    @When("the user enters the credentials {string} and {string}")
    public void the_user_enters_the_credentials_and(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("the user enters the invalid credentials {string} and {string}")
    public void the_user_enters_the_invalid_credentials_and(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("the user click on the login button")
    public void the_user_click_on_the_login_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        if (!wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='My Account']"))).isDisplayed()) {
            throw new AssertionError("My Account page not displayed");
        }
    }

    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        if (!wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Hello')]"))).isDisplayed()) {
            throw new AssertionError("Welcome message not displayed");
        }
    }

    @Then("the user should see the login page")
    public void the_user_should_see_the_login_page() {
       if (!wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Login']"))).isDisplayed()) {
           throw new AssertionError("Login page not displayed");
       }
       driver.quit();
    }
}