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

    @When("the user enters {string} inside the search input")
    public void the_user_enters_inside_the_search_input(String term) {
        searchActions.searchFor(term);
    }

    @Then("the user should see a list of articles with titles that match the entered {string}")
    public void the_user_should_see_a_list_of_articles_with_titles_that_match_the_entered(String term) {
        searchActions.verifyUserSeeSearchResult(term);
    }
}
