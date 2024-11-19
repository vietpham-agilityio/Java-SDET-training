package objectbehaviors.rules;

import helpers.TableRow;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public interface IDataTable {
    List<String> getTableHeaders();
    List<WebElementFacade> getRowElements();
    String getColumnValue(int row, String columnName);
    String getNameFromRow(int rowIndex);
    String getEmailFromRow(int rowIndex);
    String getSalaryFromRow(int rowIndex);
    String getJobTitleFromRow(int rowIndex);
    String getStartDateFromRow(int rowIndex);
    List<TableRow> getAllRowLocators();
}
