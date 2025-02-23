package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import constants.SerenityConfigConstants;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import pages.BasePage;
import pages.EmployeeTablePage;
import pages.HomePage;

import org.assertj.core.api.SoftAssertions;

import java.time.Duration;
import java.util.List;

public class HomeActions extends BasePage {

    private HomePage homePage;
    private EmployeeTablePage employeeTablePage;

    public void navigateToHomePage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.DASHBOARD_URL);
        Serenity.getDriver().get(url);
    }

    public void clickOnButtonExpandAll() {
        clickElement(homePage.buttonExpandAll(), Duration.ofSeconds(2));
    }

    public void verifyDisplayTableHeaders() {
        List<String> listHeaders = employeeTablePage.getTableHeaders();
        assertThat(listHeaders)
                .containsExactly("Name", "Email", "Salary", "Job Title", "Start Date");
    }

    public void verifyDisplayTableRows(int rows) {
        List<WebElementFacade> listRows = employeeTablePage.getRowElements();
        assertThat(listRows.size())
                .isGreaterThanOrEqualTo(rows);
    }

    public void verifyDataRow(int rowIndex) {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(employeeTablePage.getNameFromRow(rowIndex)).isEqualTo("Silas Hermiston");
        softAssertions.assertThat(employeeTablePage.getEmailFromRow(rowIndex)).isEqualTo("Jane_Hoeger42@gmail.com");
        softAssertions.assertThat(employeeTablePage.getSalaryFromRow(rowIndex)).isEqualTo("$64,532");
        softAssertions.assertThat(employeeTablePage.getJobTitleFromRow(rowIndex)).isEqualTo("International Operations Consultant");
        softAssertions.assertThat(employeeTablePage.getStartDateFromRow(rowIndex)).isEqualTo("6/3/2022");

        softAssertions.assertAll();
    }
}
