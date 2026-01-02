package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.ConfigReader;

@Epic("EYOUTH Website")
@Feature("Sign Up Features")

public class SignUpTest extends BaseTest {


    @Test(description = "Open registration page")
    @Story("registration page Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Opening registration page")

    public void openSignupPage() {

        HomePage homePage = new HomePage(driver, wait);
        homePage.clickJoinUs();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "Signup URL is incorrect"
        );
}

@Test(description = "Register with empty username field")
@Story("registration page Functionality")
@Severity(SeverityLevel.CRITICAL)
@Description("Verify Register with empty username field")

    public void signupWithEmptyUsername() {

        driver.get(ConfigReader.getBaseUrl() + "signup");

        SignUpPage signupPage = new SignUpPage(driver, wait);

        signupPage.fillForm(
                "",
                "test@email.com",
                "Password123"
        );
        signupPage.submit();

        Assert.assertEquals(
                signupPage.getUsernameError(),
                "اسم المستخدم مطلوب",
                "Validation message is incorrect"
        );
    }


}
