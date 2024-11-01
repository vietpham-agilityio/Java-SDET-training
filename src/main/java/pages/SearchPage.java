package pages;

import net.serenitybdd.core.pages.PageObject;
import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends PageObject {
    private final By search_input = By.id("search-input"),
        search_results_session = By.id("substories"),
        search_form_result = By.xpath("//ul[@id='search-typeahead']//li//strong"),
        header_search_result = By.xpath("//h1"),
        article_item_result = By.xpath("//article[.//a[contains(text(), 'BDD')]]"),
        search_icon = By.xpath("//div[contains(@class, 'crayons-field')]//input[@id='search-input']/following-sibling::button[@type='submit' and @aria-label='Search']");

    public WebElement searchInput() {
        return new WebElementImpl($(search_input));
    }

    public WebElement searchResultsSession() {
        return new WebElementImpl($(search_results_session));
    }

    public WebElement searchFormResults() {
        return new WebElementImpl($(search_form_result));
    }

    public WebElement headerSearchResults() {
        return new WebElementImpl($(header_search_result));
    }

    public WebElement searchIcon() {
        return new WebElementImpl($(search_icon));
    }

    public List<WebElement> articleItem() {
        return $$(article_item_result).stream()
                .map(WebElementImpl::new)
                .collect(Collectors.toList());
    }
}
