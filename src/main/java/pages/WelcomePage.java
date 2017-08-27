package pages;

import helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by pc on 27.08.2017.
 */
public class WelcomePage extends BasePage {
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sidebar-scroll")
    WebElement sideBar;

    @FindBy(xpath = "//a[@data-ng-click=\"logout()\"]")
    WebElement logoutButton;

    public boolean isSideBarDisplayed() {
        return isElementDisplayed(sideBar);
    }

    public LoginPage logout() {
        $(logoutButton).click();
        return new LoginPage(driver);
    }

}
