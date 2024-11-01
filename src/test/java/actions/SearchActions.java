package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import contants.SerenityConfigConstants;
import objectbehaviors.rules.WebElement;
import org.assertj.core.api.SoftAssertions;
import pages.SearchPage;

import java.util.List;

public class SearchActions {

    private SearchPage searchPage;

    public void navigateToHomePage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.DEV_URL);
        Serenity.getDriver().get(url);
    }

    public void searchFor(String term) {
        searchPage.searchInput().click();
        searchPage.searchInput().sendKeys(term);
    }

    public void verifyUserSeeSearchResultDropdown(String term) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(searchPage.searchFormResults().isDisplayed()).isTrue();
        softAssertions.assertAll();
    }

    public void clickSearchIcon() {
        searchPage.searchIcon().click();
    }

    public void verifyUserSeeSearchResultSession(String term) {
        SoftAssertions softAssertions = new SoftAssertions();

        List<WebElement> webElements = searchPage.articleItem();

        softAssertions.assertThat(searchPage.headerSearchResults().isVisible()).isTrue();
        softAssertions.assertThat(searchPage.headerSearchResults().getText()).contains("Search results for " + term);

        for (WebElement webElement : webElements) {
            softAssertions.assertThat(webElement.isDisplayed()).isTrue();
        }

        softAssertions.assertAll();
    }
}
