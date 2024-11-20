package objectbehaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public interface IDataTable {
    List<String> getTableHeaders();
    List<WebElementFacade> getRowElements();
    String getDataFromRow(int rowIndex, String columnName);
    int getColumnIndex(String columnName);
}
