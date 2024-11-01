package pages;

import net.serenitybdd.core.pages.PageObject;
import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {
    private final By search_input = By.id("search-input"),
        search_results = By.id("substories"),
        search_form_result = By.xpath("//ul[@id='search-typeahead']//li//strong");

    public WebElement searchInput() {
        return new WebElementImpl($(search_input));
    }

    public WebElement searchFormResults() {
        return new WebElementImpl($(search_form_result));
    }

    public WebElement searchResults() {
        return new WebElementImpl($(search_results));
    }

}
