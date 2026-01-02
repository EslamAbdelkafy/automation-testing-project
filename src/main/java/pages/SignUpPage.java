package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement createAccountBtn;

    @FindBy(id = "username-helper-text")
    private WebElement usernameError;




    @Step("Fill Sign Up Form with username, password and email")
    public void fillForm(String username, String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        if (!username.isEmpty()) {
            usernameInput.sendKeys(username);
        }
    }

    @Step("Submit Sign Up Form")
    public void submit() {
        createAccountBtn.click();
    }


    @Step("Get Username Error Message")
    public String getUsernameError() {
        return wait.until(ExpectedConditions.visibilityOf(usernameError)).getText();
    }

}
