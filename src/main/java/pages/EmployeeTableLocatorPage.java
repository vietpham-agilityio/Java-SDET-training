package pages;

import org.openqa.selenium.By;

public class EmployeeTableLocatorPage {
    private static final String CELL_TEMPLATE = "//tr[@data-index='%d']//td[@data-index='%s']";

    public By getRowElement(int rowIndex, int cellIndex) {
        return By.xpath(String.format(CELL_TEMPLATE, rowIndex, cellIndex));
    }
}
