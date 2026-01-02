package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

@Epic("EYOUTH Website")
@Feature("Search Features")

public class SearchTests extends BaseTest {
 HomePage homePage;
    @Test(description = "Search with valid Arabic keyword")
    @Story("Search Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify search works with valid Arabic keyword")

    public void searchWithValidKeyword() {

        HomePage homePage = new HomePage(driver, wait);

        String keyword = "كيف تنضم إلى البنك";
        homePage.searchForKeyword(keyword);}


        public void verifyCourseTitle (String keyword){
            String actualTitle = homePage.waitAndGetCourseTitle();


            Assert.assertTrue(
                    actualTitle.contains("تنضم") || actualTitle.contains("البنك"),
                    "Course title does not match the search keyword"
            );


        }
    }