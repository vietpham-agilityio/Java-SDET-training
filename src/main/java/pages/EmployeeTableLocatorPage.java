package pages;

import helpers.TableRow;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTableLocatorPage {
    private static final String CELL_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='%d']";

    private static final int NAME_COLUMN = 2;
    private static final int EMAIL_COLUMN = 3;
    private static final int SALARY_COLUMN = 4;
    private static final int JOB_TITLE_COLUMN = 5;
    private static final int START_DATE_COLUMN = 6;

    private final List<WebElementFacade> rowElements;

    public EmployeeTableLocatorPage(List<WebElementFacade> rowElements) {
        this.rowElements = rowElements;
    }

    public TableRow getRowData(int index) {
        return new TableRow(
                getNameByRowIndex(index),
                getEmailByRowIndex(index),
                getSalaryByRowIndex(index),
                getJobTitleByRowIndex(index),
                getStartDateByRowIndex(index)
        );
    }

    public List<TableRow> getAllRowsData() {
        List<TableRow> allRows = new ArrayList<>();

        for (int i = 0; i < rowElements.size(); i = i + 2) {
            TableRow rowData = getRowData(i);
            allRows.add(rowData);
        }

        return allRows;
    }

    private String getNameByRowIndex(int rowIndex) {
        return findCellText(rowIndex, NAME_COLUMN);
    }

    private String getEmailByRowIndex(int rowIndex) {
        return findCellText(rowIndex, EMAIL_COLUMN);
    }

    private String getSalaryByRowIndex(int rowIndex) {
        return findCellText(rowIndex, SALARY_COLUMN);
    }

    private String getJobTitleByRowIndex(int rowIndex) {
        return findCellText(rowIndex, JOB_TITLE_COLUMN);
    }

    private String getStartDateByRowIndex(int rowIndex) {
        return findCellText(rowIndex, START_DATE_COLUMN);
    }

    public By getRowElement(int rowIndex, int cellIndex) {
        return By.xpath(String.format(CELL_TEMPLATE, rowIndex, cellIndex));
    }

    private String findCellText(int rowIndex, int columnIndex) {
        By cellLocator = getRowElement(rowIndex, columnIndex);
        return rowElements.get(rowIndex).find(cellLocator).getText();
    }
}
