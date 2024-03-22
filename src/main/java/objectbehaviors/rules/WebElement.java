package objectbehaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

public interface WebElement {
    WebElementFacade getWrappedElement();

    void click();

    void sendKeys(String text);

    void typeAndEnter(String text);

    boolean isDisplayed();
}
