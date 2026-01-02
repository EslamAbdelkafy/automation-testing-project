package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CourseDetailsPage;
import pages.CoursesPage;
import pages.HomePage;

@Epic("EYOUTH Website")
@Feature("course page details ")


public class CourseTests extends BaseTest {
    HomePage homePage;

 @Test(description = "Open course details page")
 @Story("course Page Functionality")
 @Severity(SeverityLevel.CRITICAL)
 @Description("Verify Opening course details page")

    public void clickAllCoursesTest() {
        homePage = new HomePage(driver, wait);
        homePage.openAllCoursesFromMenu();

        CoursesPage coursesPage = new CoursesPage(driver, wait);
        coursesPage.openAnyCourse();
        CourseDetailsPage detailsPage = new CourseDetailsPage(driver, wait);

        Assert.assertTrue(detailsPage.isCourseDetailsPageOpen(),
                "Course details page should be opened");

        Assert.assertTrue(detailsPage.isAboutSectionDisplayed(),
                "About course section is not displayed");
    }

@Test(description = "Verify course card UI elements")
@Story("course card UI elements Functionality")
@Severity(SeverityLevel.CRITICAL)
@Description("Verify course card UI elements")
    public void verifyCourseCardUI() {

        HomePage homePage = new HomePage(driver, wait);
        homePage.openAllCoursesFromMenu();

        CoursesPage coursesPage = new CoursesPage(driver, wait);
        coursesPage.openAnyCourse();

        Assert.assertTrue(coursesPage.isImageDisplayed(), "Course image not displayed");
        Assert.assertTrue(coursesPage.isTitleDisplayed(), "Course title not displayed");
        Assert.assertTrue(coursesPage.isInstructorDisplayed(), "Instructor name not displayed");
        Assert.assertTrue(coursesPage.isSubscribeButtonDisplayed(), "Subscribe button not displayed");
    }


}
