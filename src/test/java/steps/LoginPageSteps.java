package steps;

import actions.AuthenticationActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginPageSteps {
    @Steps
    private AuthenticationActions authenticationActions;

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
       authenticationActions.navigateToLoginPage();
    }

    @Given("the user enters a valid username and password on page login")
    public void the_user_enters_a_valid_username_and_password_on_page_login() {
        authenticationActions.typeCredentials("repsweet080303@gmail.com", "AsusZenbook12123412!");
    }

    @When("click on the button login on page login")
    public void click_on_the_button_login_on_page_login() {
        authenticationActions.clickLoginButton();
    }

    @Then("verify user is able to login successfully")
    public void verify_user_is_able_to_login_successfully() {
        authenticationActions.verifyUserLoggedIn();
    }
}
