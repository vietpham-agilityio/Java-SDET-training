package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.AbstractGuiElement;

public class WebElement extends AbstractGuiElement implements object_behaviors.rules.WebElement {
    private final WebElementFacade element;

    public WebElement(WebElementFacade element) {
        super(element);
        this.element = element;
    }

    public WebElement(WebElementFacade element, String name) {
        super(element, name);
        this.element = element;
    }
}
