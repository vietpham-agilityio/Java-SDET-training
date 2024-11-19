package pages;

import helpers.TableRow;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeTableLocatorPage {
    private static final String NAME_ROW_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='2']//span";
    private static final String EMAIL_ROW_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='3']//button";
    private static final String SALARY_ROW_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='4']//div";
    private static final String JOB_TITLE_ROW_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='5']";
    private static final String START_DATE_ROW_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='6']";

    private final List<WebElementFacade> rowElements;

    public EmployeeTableLocatorPage(List<WebElementFacade> rowElements) {
        this.rowElements = rowElements;
    }

    //TODO: Will update for get all data inside Table
    public List<TableRow> getAllRowsData() {
        return IntStream.range(0, rowElements.size())
                .mapToObj(this::getRowData)
                .collect(Collectors.toList());
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

    public By getNameByRowIndex(int index) {
        return By.xpath(String.format(NAME_ROW_TEMPLATE, index));
    }

    public By getEmailByRowIndex(int index) {
        return By.xpath(String.format(EMAIL_ROW_TEMPLATE, index));
    }

    public By getSalaryByRowIndex(int index) {
        return By.xpath(String.format(SALARY_ROW_TEMPLATE, index));
    }

    public By getJobTitleByRowIndex(int index) {
        return By.xpath(String.format(JOB_TITLE_ROW_TEMPLATE, index));
    }

    public By getStartDateByRowIndex(int index) {
        return By.xpath(String.format(START_DATE_ROW_TEMPLATE, index));
    }
}
