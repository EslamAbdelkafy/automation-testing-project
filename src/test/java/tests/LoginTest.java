package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

@Epic("EYOUTH Website")
@Feature("Login Features")

public class LoginTest extends BaseTest {

    @Test(description = "Login with invalid credentials")
    @Story("Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Login with invalid credentials")
    public void loginWithInvalidCredentials() {

        driver.get(ConfigReader.getBaseUrl() + "signin");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(
                ConfigReader.getInvalidUsername(),
                ConfigReader.getInvalidPassword()
        );

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message not displayed"
        );
    }

    @Test(description = "Login with empty fields")
    @Story("Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Login with empty fields")
    public void loginWithEmptyFields() {

        driver.get(ConfigReader.getBaseUrl() + "signin");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("", "");

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Validation messages not displayed for empty fields"
        );
    }
}
