package pages;

import helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//form/div[5]/div/button[@type=\"submit\"]")
    WebElement submitButton;

    @FindBy(css = ".btn.btn-block.btn-primary.mheight-40.text-uppercase.ng-binding")
    WebElement submitButton1;

    @FindBy(xpath = "//a[@ui-sref='reminder']")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//div[@data-ng-show='errorMsg']")
    WebElement errorIncorrectCredentials;

    public WelcomePage loginToApp(String login, String password) throws InterruptedException {
        driver.get("https://my-sandbox.maxpay.com/#/signin");
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MILLISECONDS);
        $(loginField).shouldBe(visible).click();
        $(loginField).setValue(login);
        $(passwordField).shouldBe(visible).click();
        $(passwordField).setValue(password);
        $(submitButton).click();
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        return new WelcomePage(driver);
    }

    public boolean isForgotPasswordButtonDisplayed() {
        return isElementDisplayed(forgotPasswordButton);
    }

    public boolean isErrorMessageForIncorrectCredentialsDisplaye() {
        return isElementDisplayed(errorIncorrectCredentials);
    }

    public String getTextFromErrorMessage() {
        return $(errorIncorrectCredentials).shouldBe(visible).getText();
    }

}
