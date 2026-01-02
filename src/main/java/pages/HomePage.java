package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='search']")
    private WebElement searchInput;
    @FindBy(linkText = "دوراتنا التدريبية")
    private WebElement trainingCoursesMenu;
    @FindBy(linkText = "جميع الدورات")
    private WebElement allCoursesLink;
    @FindBy(xpath = "//button[normalize-space()='انضم لنا']")
    private WebElement signupLink;





    @Step("Search for keyword: {keyword}")
    public void searchForKeyword(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();
        searchInput.sendKeys(keyword);

        By suggestionsLocator = By.xpath("//ul[contains(@class,'MuiAutocomplete-listbox')]//li");

        List<WebElement> suggestions =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionsLocator));

        for (WebElement suggestion : suggestions) {
            suggestion.click();
            break;
        }
        searchInput.sendKeys( Keys.ENTER);

    }

    @Step("Wait and Get Course Title")
    public String waitAndGetCourseTitle() {
        By courseTitleLocator = By.cssSelector("h1.course-title");
        WebElement courseTitleElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(courseTitleLocator)
        );
        return courseTitleElement.getText();
    }


@Step("Open All Courses from Menu")
public void openAllCoursesFromMenu() {
    wait.until(ExpectedConditions.visibilityOf(trainingCoursesMenu));

    Actions actions = new Actions(driver);

    // Hover  "دوراتنا التدريبية"
    actions.moveToElement(trainingCoursesMenu).perform();

    wait.until(ExpectedConditions.visibilityOf(allCoursesLink));
    wait.until(ExpectedConditions.elementToBeClickable(allCoursesLink)).click();
}

@Step("Click on Join Us button")
public void clickJoinUs() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(signupLink)).click();
    } catch (TimeoutException e) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", signupLink);
    }
}





}







