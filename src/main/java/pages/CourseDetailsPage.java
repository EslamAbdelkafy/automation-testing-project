package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CourseDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CourseDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "h1.courseDetails_courseTitle__tmIRd")
    private WebElement courseTitle;
    @FindBy(xpath = "//h2[contains(text(),'حول الدورة التدريبية')]")
    private WebElement aboutCourseSection;


    @Step("Check if Course Details Page is Open")

    public boolean isCourseDetailsPageOpen() {
        return wait.until(ExpectedConditions.visibilityOf(courseTitle)).isDisplayed();
    }


    @Step("Check if About Course Section is Displayed")

        public boolean isAboutSectionDisplayed () {
            return wait.until(ExpectedConditions.visibilityOf(aboutCourseSection)).isDisplayed();
        }
    }

