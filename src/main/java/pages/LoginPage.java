package pages;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    /* ================= Locators ================= */

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(css = ".MuiAlert-message")
    private WebElement errorMessage;
    @FindBy(id = "username")
    private WebElement usernameRequiredError;
    @FindBy(id = "password")
    private WebElement passwordRequiredError;



    @Step("Login with username: {username} and password: {password}")

    public void login( String username, String password) {
        if (!username.isEmpty()) usernameInput.sendKeys(username);
        if (!password.isEmpty()) passwordInput.sendKeys(password);
        loginBtn.click();

    }



    @Step("Check if Error Message is Displayed")
    public boolean isErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(usernameRequiredError));
        wait.until(ExpectedConditions.visibilityOf(passwordRequiredError));
        return true;
    }

    }

