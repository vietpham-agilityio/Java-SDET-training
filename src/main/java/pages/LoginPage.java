package pages;

import net.serenitybdd.core.pages.PageObject;
import objectbehaviors.implementation.WebElementImpl;
import objectbehaviors.rules.WebElement;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private final By login_button = By.xpath("//input[@type='submit' and @value='Log in']"),
    email_input = By.xpath("//input[@name='user[email]']"),
    password_input = By.xpath("//input[@name='user[password]']");


    public WebElement loginButton() {
        return new WebElementImpl($(login_button));
    }

    public WebElement emailInput() {
        return new WebElementImpl($(email_input));
    }

    public WebElement passwordInput() {
        return new WebElementImpl($(password_input));
    }
}
