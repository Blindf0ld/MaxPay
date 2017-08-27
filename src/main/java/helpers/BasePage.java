package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pc on 27.08.2017.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver browser) {
        this.driver = browser;
        PageFactory.initElements(browser, this);
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
