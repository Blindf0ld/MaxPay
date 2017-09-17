package pages;

import helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by pc on 27.08.2017.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login-email")
    WebElement loginField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(css = ".btn.btn-block.btn-primary.mheight-40.text-uppercase.ng-binding")
    WebElement submitButton;

    @FindBy(xpath = "//a[@ui-sref='reminder']")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//div[@data-ng-show='errorMsg']")
    WebElement errorIncorrectCredentials;

    public WelcomePage loginToApp(String login, String password) throws InterruptedException {
        driver.get("https://my-sandbox.maxpay.com/#/signin");
        $(loginField).shouldBe(visible).click();
        $(loginField).setValue(login);
        $(passwordField).shouldBe(visible).click();
        $(passwordField).setValue(password);
        $(submitButton).shouldBe(exist).click();
        return new WelcomePage(driver);
    }

    public boolean isForgotPasswordButtonDisplayed() {
        return isElementDisplayed(forgotPasswordButton);
    }

    public boolean isErrorMessageForIncorrectCredentialsDisplayed() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement element = wait.until()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        return driver.findElement(By.xpath("//div[@data-ng-show='errorMsg']")).isDisplayed();
    }

    public String getTextFromErrorMessage() {
        return $(errorIncorrectCredentials).shouldBe(visible).getText();
    }

}
