package objectbehaviors.implementation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import objectbehaviors.rules.WebElement;
import org.awaitility.Awaitility;

import java.time.Duration;

public class WebElementImpl extends PageObject implements WebElement {
    protected WebElementFacade element;

    public WebElementImpl(WebElementFacade element) {
        this.element = element;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void sendKeys(String text) {
        element.clear();
        element.sendKeys(text);
    }

    @Override
    public void typeAndEnter(String text) {
        element.typeAndEnter(text);
    }

    @Override
    public void typeInto(String text) {element.type(text);}

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public boolean isVisible() {return element.isVisible();}

    @Override
    public void waitUntilVisible(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(this::isVisible);
    }
}
