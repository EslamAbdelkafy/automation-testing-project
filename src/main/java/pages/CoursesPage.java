package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CoursesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CoursesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".course-card")
    private List<WebElement> courseCards;
    @FindBy(xpath = "//h2[contains(text(),'حول الدورة التدريبية')]")
    private WebElement aboutCourseSection;
    @FindBy(xpath = "//button[normalize-space()='أضف الي السلة']")
    private WebElement subscribeButton;
    @FindBy(css = "h1.courseDetails_courseTitle__tmIRd")
    private WebElement courseTitle;
    @FindBy(css = "div.react-player__preview")
    private WebElement courseImage;
    @FindBy(css = "a.InstructorCourseDetails_Name__mTOpV")
    private WebElement instructorName;



    @Step("Open Any Course from Courses Page")

    public void openAnyCourse() {
        wait.until(ExpectedConditions.visibilityOfAllElements(courseCards));
        courseCards.get(1).click();
    }


    @Step("Check if About Course Section is Displayed")
    public boolean isAboutSectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(aboutCourseSection)).isDisplayed();
    }

    @Step("Click Subscribe Button")
    public void clickSubscribe() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    @Step("Get Course Title")
    public String getCourseTitle() {
        return wait.until(ExpectedConditions.visibilityOf(courseTitle))
                .getText()
                .trim();
    }

    @Step("Check if Course Image is Displayed")
    public boolean isImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(courseImage)).isDisplayed();
    }

    @Step("Check if Course Title is Displayed")
    public boolean isTitleDisplayed() {
        return courseTitle.isDisplayed();
    }

    @Step("Check if Instructor Name is Displayed")
    public boolean isInstructorDisplayed() {
        return instructorName.isDisplayed();
    }

    @Step("Check if Subscribe Button is Displayed")
    public boolean isSubscribeButtonDisplayed() {
        return subscribeButton.isDisplayed();
    }


}