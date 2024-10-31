package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import contants.SerenityConfigConstants;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import pages.SearchPage;


public class SearchActions {

    private SearchPage searchPage;

    public void navigateToHomePage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.DEV_URL);
        Serenity.getDriver().get(url);
    }

    public void searchFor(String term) {
        searchPage.searchInput().sendKeys(term);
    }

    public void verifyUserSeeSearchResult(String term) {
        SoftAssertions softAssertions = new SoftAssertions();
        searchPage.searchFormResults().waitUntilVisible();

        softAssertions.assertAll();
    }
}
