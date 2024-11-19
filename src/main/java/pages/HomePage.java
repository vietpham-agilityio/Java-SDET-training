package pages;

import objectbehaviors.rules.WebElement;

public class HomePage extends BasePage {

    public WebElement buttonExpandAll() {
        return xpathButtonByAriaLabel("Expand all");
    }
}
