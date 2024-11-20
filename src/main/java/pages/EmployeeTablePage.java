package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import objectbehaviors.rules.IDataTable;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTablePage extends BasePage implements IDataTable {

    private static final String TABLE_HEADER = "//*[text()='%s']/ancestor::th";
    private static final By TABLE_HEADERS = By.xpath("//div[contains(@class, 'mrt-table-head-cell-content-wrapper')]");
    private static final By TABLE_ROWS = By.xpath("//tr[contains(@class, 'MRT_TableBodyRow-module_root')]");

    public EmployeeTableLocatorPage getTableLocator() {
        return new EmployeeTableLocatorPage();
    }

    @Override
    public int getColumnIndex(String columnName) {
        var xpathExpression  = String.format(TABLE_HEADER, columnName);

        String rowIndex = find(By.xpath(xpathExpression )).getAttribute("data-index");
        return Integer.parseInt(rowIndex);
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
    public String getDataFromRow(int rowIndex, String columnName) {
        int columnIndex = getColumnIndex(columnName);

        EmployeeTableLocatorPage tableLocator = getTableLocator();
        return find(tableLocator.getRowElement(rowIndex, columnIndex)).getText();
    }
}
