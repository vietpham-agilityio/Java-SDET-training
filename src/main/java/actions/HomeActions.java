package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import constants.SerenityConfigConstants;
import pages.BasePage;
import pages.HomePage;

import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

public class HomeActions extends BasePage {

    private HomePage homePage;

    public void navigateToHomePage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.DASHBOARD_URL);
        Serenity.getDriver().get(url);
    }

    public void verifyUserOnHomePage() {

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(homePage.tableHeadingEmployee().isDisplayed()).isTrue();
        softAssertions.assertThat(homePage.tableHeadingJobInfo().isDisplayed()).isTrue();
        softAssertions.assertAll();

    }

    public void clickOnButtonExpandAll() {
        clickElement(homePage.buttonExpandAll(), Duration.ofSeconds(2));
    }
}
