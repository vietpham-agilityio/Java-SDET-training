package steps;

import actions.AuthenActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginPageSteps {
    @Steps
    private AuthenActions authenActions;

    @Given("The user is on Dev page")
    public void the_user_is_on_dev_page() {
        authenActions.navigateToPage();
    }
    @When("The user clicks on the “Log in” button in the navigation bar")
    public void the_user_clicks_on_the_log_in_button_in_the_navigation_bar() {
        System.out.println("Step 2");
//        throw new io.cucumber.java.PendingException();
    }
    @Then("The user is navigated to the login page.")
    public void the_user_is_navigated_to_the_login_page() {
//        throw new io.cucumber.java.PendingException();
    }
}
