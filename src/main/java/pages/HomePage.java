package pages;

import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By INPUT_SELECT_ROW = By.xpath("//p[@id='rpp-label']/following-sibling::div");

    public WebElement buttonExpandAll() {
        return xpathButtonByAriaLabel("Expand all");
    }

    public WebElement inputSelectRow() {
        return new WebElementImpl($(INPUT_SELECT_ROW));
    }

    public WebElement selectPerPageOption() {
        By selectOptionXpath = xpathByContainsClass("div", "mantine-Select-dropdown");
        return new WebElementImpl($(selectOptionXpath));
    }
}
