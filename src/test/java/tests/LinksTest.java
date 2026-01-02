package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Links;

@Epic("EYOUTH Website")
@Feature("Links Features")

public class LinksTest extends BaseTest {

    @Test(description = "Verify Facebook link")
    @Story("Links Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify opening Facebook link")
    public void verifyFacebookLink() {

        Links links = new Links(driver, wait);

        links.clickFacebook();


        Assert.assertTrue(
                driver.getCurrentUrl().contains("facebook.com"),
                "Facebook URL is incorrect"
        );
    }

    @Test(description = "Verify LinkedIn link")
    @Story("Links Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify opening LinkedIn link")
    public void verifyLinkedInLink() {

        Links links = new Links(driver, wait);
        links.clickLinkedIn();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("linkedin.com"),
                "LinkedIn URL is incorrect"
        );
    }

    @Test(description = "Verify Instagram link")
    @Story("Links Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify opening Instagram link")
    public void verifyInstagramLink() {

        Links links = new Links(driver, wait);
        links.clickInstagram();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("instagram.com"),
                "Instagram URL is incorrect"
        );
    }
}
