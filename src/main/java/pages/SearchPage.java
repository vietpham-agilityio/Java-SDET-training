package pages;

import net.serenitybdd.core.pages.PageObject;
import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {
    private final By search_input = By.id("searchbox_input"),
        search_result = By.xpath("//article"),
        search_form_input = By.id("search_form_input");

    public WebElement searchInput() {
        return new WebElementImpl($(search_input));
    }

    public WebElement searchResult() {
        return new WebElementImpl($(search_result));
    }

    public WebElement searchFormInput() {
        return new WebElementImpl($(search_form_input));
    }
}
