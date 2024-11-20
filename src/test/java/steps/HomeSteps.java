package steps;

import actions.HomeActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomeSteps {

    @Steps
    private HomeActions homeActions;

    @Given("the user is on Home page")
    public void the_user_is_on_home_page() {
        homeActions.navigateToHomePage();
        homeActions.verifyDisplayTableHeaders();
    }

    @When("the user click on Expand all button")
    public void the_user_click_on_expand_all_button() {
        homeActions.clickOnButtonExpandAll();
    }

    @Then("verify default display ten employees per page")
    public void verify_default_display_ten_employees_per_page() {
        homeActions.verifyDisplayTableRows(10);
        homeActions.verifyDataRow(12);
        homeActions.verifyDataTable();
    }
}
