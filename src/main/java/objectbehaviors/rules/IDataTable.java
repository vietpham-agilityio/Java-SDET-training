package objectbehaviors.rules;

import helpers.TableRow;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public interface IDataTable {
    List<TableRow> getDataTable();
    List<String> getTableHeaders();
    List<WebElementFacade> getRowElements();
    String getDataFromRow(int rowIndex, String columnName);
    int getColumnIndex(String columnName);
}
