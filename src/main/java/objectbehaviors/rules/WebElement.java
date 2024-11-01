package objectbehaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public interface WebElement {
    WebElementFacade getWrappedElement();

    void click();

    void sendKeys(String text);

    void typeAndEnter(String text);

    void typeInto(String text);

    boolean isVisible();

    boolean isDisplayed();

    void waitUntilVisible(Duration waitAtMost);

    String getText();
}
