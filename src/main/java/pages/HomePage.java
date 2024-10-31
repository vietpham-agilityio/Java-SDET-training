package pages;

import net.serenitybdd.core.pages.PageObject;
import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private final By profile_image = By.id("nav-profile-image");

    public WebElement profileImage() {
        return new WebElementImpl($(profile_image));
    }
}
