package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import objectbehaviors.rules.IDataTable;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import helpers.TableRow;

public class EmployeeTablePage extends BasePage implements IDataTable {

    private static final By TABLE_HEADERS = By.xpath("//div[contains(@class, 'mrt-table-head-cell-content-wrapper')]");
    private static final By TABLE_ROWS = By.xpath("//tr[contains(@class, 'MRT_TableBodyRow-module_root')]");

    public EmployeeTableLocatorPage getTableLocator() {
        return new EmployeeTableLocatorPage(getRowElements());
    }

    @Override
    public List<String> getTableHeaders() {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(TABLE_HEADERS);

        return findAll(TABLE_HEADERS)
                .stream()
                .map(WebElementFacade::getText)
                .filter(text -> !text.isEmpty())
                .filter(text -> !text.equals("Employee") && !text.equals("Job Info") && !text.equals("Actions"))
                .collect(Collectors.toList());
    }

    @Override
    public List<WebElementFacade> getRowElements() {
        return findAll(TABLE_ROWS);
    }

    @Override
    public String getNameFromRow(int rowIndex) {
        EmployeeTableLocatorPage locator = getTableLocator();
        return find(locator.getNameByRowIndex(rowIndex)).getText();
    }

    @Override
    public String getEmailFromRow(int rowIndex) {
        EmployeeTableLocatorPage locator = getTableLocator();
        return find(locator.getEmailByRowIndex(rowIndex)).getText();
    }

    @Override
    public String getSalaryFromRow(int rowIndex) {
        EmployeeTableLocatorPage locator = getTableLocator();
        return find(locator.getSalaryByRowIndex(rowIndex)).getText();
    }

    @Override
    public String getJobTitleFromRow(int rowIndex) {
        EmployeeTableLocatorPage locator = getTableLocator();
        return find(locator.getJobTitleByRowIndex(rowIndex)).getText();
    }

    @Override
    public String getStartDateFromRow(int rowIndex) {
        EmployeeTableLocatorPage locator = getTableLocator();
        return find(locator.getStartDateByRowIndex(rowIndex)).getText();
    }

    @Override
    public List<TableRow> getAllRowLocators() {
        return getTableLocator().getAllRowsData();
    }

    @Override
    public String getColumnValue(int row, String columnName) {
        return "";
    }
}
