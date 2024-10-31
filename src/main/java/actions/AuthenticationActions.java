package actions;

import contants.SerenityConfigConstants;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import objectbehaviors.implementation.WebElementImpl;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import org.openqa.selenium.By;

public class AuthenticationActions {

    public static WebDriver driver;

    private LoginPage loginPage;

    public void navigateToLoginPage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.DEV_LOGIN_URL);
        Serenity.getDriver().get(url);
    }

    public void typeCredentials(String username, String password) {
        loginPage.emailInput().sendKeys(username);
        loginPage.passwordInput().sendKeys(password);
    }

    public void clickLoginButton() {
        loginPage.loginButton().click();
    }

    public void verifyUserLoggedIn() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        WebElement ProfileImage = driver.findElement(By.id("nav-profile-image"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(ProfileImage.isDisplayed()).as("Profile image of user when logged").isTrue();
        softAssertions.assertAll();
    }
}
