package objectbehaviors.implementation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import objectbehaviors.rules.WebElement;

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
    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}
