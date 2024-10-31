package steps;

import actions.SearchActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SearchSteps {

    @Steps
    private SearchActions searchActions;

    @Given("user is researching articles on the DEV community")
    public void user_is_researching_articles_on_the_dev_community() {
        searchActions.navigateToHomePage();
    }

    @When("user looks up {string}")
    public void searches_for(String term) {
        searchActions.searchFor(term);
    }

    @Then("user should see articles have title match with {string}")
    public void user_should_see_articles_have_title_match_with(String term) {
        searchActions.verifyUserSeeSearchResult(term);
    }
}
