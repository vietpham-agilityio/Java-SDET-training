package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import constants.SerenityConfigConstants;
import pages.BasePage;
import pages.EmployeeTablePage;
import pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

    public void clickOnInputSelectRow() {
        clickElement(homePage.inputSelectRow(), Duration.ofSeconds(2));
    }

    public void verifyDisplayTableHeaders() {
        List<String> listHeaders = employeeTablePage.getTableHeaders();
        assertThat(listHeaders)
                .containsExactly("Name", "Email", "Salary", "Job Title", "Start Date");
    }

    public void verifyDisplayTableRows(int totalRow) {
        List<WebElementFacade> listRows = employeeTablePage.getRowElements();
        assertThat(listRows.size())
                .isGreaterThanOrEqualTo(totalRow);
    }

    public void verifyDataRow(int rowIndex) {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(employeeTablePage.getDataFromRow(rowIndex, "Name")).isNotEmpty();
        softAssertions.assertThat(employeeTablePage.getDataFromRow(rowIndex, "Email")).isNotEmpty();
        softAssertions.assertThat(employeeTablePage.getDataFromRow(rowIndex, "Salary")).isNotEmpty();
        softAssertions.assertThat(employeeTablePage.getDataFromRow(rowIndex, "Job Title")).isNotEmpty();
        softAssertions.assertThat(employeeTablePage.getDataFromRow(rowIndex, "Start Date")).isNotEmpty();

        softAssertions.assertAll();
    }

    public void verifyDataTable() {
        assertThat(employeeTablePage.getDataTable()).isNotEmpty();
    }
}
