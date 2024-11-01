package steps;

import actions.SearchActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SearchSteps {

    @Steps
    private SearchActions searchActions;

    @Given("the user is on the DEV community page")
    public void the_user_is_on_the_dev_community_page() {
        searchActions.navigateToHomePage();
    }

    @When("enters {string} inside the input search on home page")
    public void enters_inside_the_input_search_on_home_page(String term) {
        searchActions.searchFor(term);
    }

    @Then("verify user is able to see list article have title match {string} on dropdown result")
    public void verify_user_is_able_to_see_list_article_have_title_match_on_dropdown_result(String term) {
        searchActions.verifyUserSeeSearchResult(term);
    }
}
