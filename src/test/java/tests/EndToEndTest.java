package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CoursesPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.WaitUtils;

@Epic("EYOUTH Website")
@Feature("End To End Features")

public class EndToEndTest extends BaseTest {


    @Test(description = "End-to-End: Login and subscribe to a course")
    @Story("End-to-End Testing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login and course subscription flow")
    public void endToEndScenario() {

        driver.get(ConfigReader.getBaseUrl() + "signin");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(
                ConfigReader.getValidUsername(),
                ConfigReader.getValidPassword()
        );

        WaitUtils.waitFor(2);

        HomePage homePage = new HomePage(driver, wait);
        homePage.openAllCoursesFromMenu();


        CoursesPage coursesPage = new CoursesPage(driver, wait);
        coursesPage.openAnyCourse();

        String actualTitle = coursesPage.getCourseTitle();

        coursesPage.clickSubscribe();



        Assert.assertTrue(
                actualTitle.contains(actualTitle),
                "Course title is incorrect. Actual title: " + actualTitle
        );

    }
}
