package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;
import java.util.Set;

public class Links {



    private WebDriver driver;
    private WebDriverWait wait;

    public Links(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = "a[href*='facebook.com/EYouth']")
    private WebElement facebookIcon;

    @FindBy(css = "a[href*='linkedin.com/company/eyouth']")
    private WebElement linkedinIcon;

    @FindBy(css = "a[href*='instagram.com/eyouth']")
    private WebElement instagramIcon;
    @FindBy(css = "div.w-50.d-flex.justify-content-around")
    private WebElement footer;
    @FindBy(css = "span.position-relative.z-1")
    private WebElement whyEyouthText;



        public void scrollToFooter( ) { JavascriptExecutor js = (JavascriptExecutor) driver;

        int scrollSteps = 5; // عدد المرات التي نريد الاسكرول فيها
        for (int i = 1; i <= scrollSteps; i++) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight * " + i + "/" + scrollSteps + ");");

            WaitUtils.waitFor(1);

        }
    }



    @Step("Click on Facebook Icon")
    public void clickFacebook() {
        scrollToFooter();

        wait.until(ExpectedConditions.elementToBeClickable(facebookIcon))
                .click();
    }


    @Step("Click on LinkedIn Icon")
    public void clickLinkedIn() {
        scrollToFooter();
        wait.until(ExpectedConditions.visibilityOf(linkedinIcon));
        linkedinIcon.click();

    }

    @Step("Click on Instagram Icon")
    public void clickInstagram() {
        scrollToFooter();
        wait.until(ExpectedConditions.visibilityOf(instagramIcon));
        instagramIcon.click();

    }
}


