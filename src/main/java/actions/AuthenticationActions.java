package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

import contants.SerenityConfigConstants;

import pages.HomePage;
import pages.LoginPage;

public class AuthenticationActions {

    public static WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;

    public void navigateToLoginPage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.DEV_LOGIN_URL);
        Serenity.getDriver().get(url);
    }

    public void typeCredentials(String username, String password) {
        loginPage.emailInput().sendKeys(username);
        loginPage.passwordInput().sendKeys(password);
    }

    public void typeInvalidCredentials(String username, String password) {
        loginPage.emailInput().sendKeys(username);
        loginPage.passwordInput().sendKeys(password);
    }

    public void clickLoginButton() {
        loginPage.loginButton().click();
    }

    public void verifyUserLoggedIn() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homePage.profileImage().isDisplayed()).as("Profile image of user when logged").isTrue();
        softAssertions.assertAll();
    }

    public void verifyUserLogInFailed() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.unableLoginMessage().isDisplayed()).as("Error message appear when user enters invalid credentials").isTrue();
        softAssertions.assertAll();
    }
}
