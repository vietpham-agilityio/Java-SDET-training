package pages;

import net.serenitybdd.core.pages.PageObject;
import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.time.Duration;

import org.jetbrains.annotations.NotNull;

public class BasePage extends PageObject{

    /**
     * Waits for a web element to be visible and clicks it.
     *
     * @param element The web element to be clicked
     * @param visibilityTimeout Maximum duration to wait for element visibility
     */
    protected void clickElement(WebElement element, Duration visibilityTimeout) {
        element.waitUntilVisible(visibilityTimeout);
        element.click();
    }

    @NotNull
    public By xpathByText(final String elementType, final String text ) {
        String xpathFormat = MessageFormat.format(
                "//{0}[contains(text(),''{1}'')]",
                elementType,
                text
        );

        return By.xpath(xpathFormat);
    }

    @NotNull
    public By xpathByAriaLabel(final String elementType, final String label ) {
        String xpathFormat = MessageFormat.format(
                "//{0}[@aria-label=''{1}'']",
                elementType,
                label
        );
        return By.xpath(xpathFormat);
    }

    @NotNull
    public WebElement xpathButtonByAriaLabel(String label) {
        By elementLocator = xpathByAriaLabel("button",label);

        return new WebElementImpl($(elementLocator));
    }
}
