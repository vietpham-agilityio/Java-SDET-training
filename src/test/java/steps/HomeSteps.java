package steps;

import actions.HomeActions;

import io.cucumber.java.en.And;
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

    @And("the user click on the Rows per page dropdown")
    public void the_user_click_on_the_rows_per_page_dropdown() {
        homeActions.clickOnInputSelectRow();
    }

    @And("the user see list options dropdown")
    public void the_user_see_list_options_dropdown() {

    }

    @When("the user select {string} from the list options dropdown")
    public void the_user_select_from_the_list_options_dropdown(String string) {

    }

    @When("the user click on Expand all button")
    public void the_user_click_on_expand_all_button() {
        homeActions.clickOnButtonExpandAll();
    }

    @Then("verify display {string} of employees per page")
    public void verify_display_of_employees_per_page(String string) {

    }

    @Then("verify default display ten employees per page")
    public void verify_default_display_ten_employees_per_page() {
        homeActions.verifyDisplayTableRows(10);
        homeActions.verifyDataRow(12);
        homeActions.verifyDataTable();
    }
}
