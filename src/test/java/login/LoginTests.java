package login;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.junit.Assert.assertThat;

/**
 * Created by pc on 27.08.2017.
 */
public class LoginTests extends BaseTest {
    String validLogin = "test_user@test.com";
    String validPassword = "Qwerty123";
    String invalidPassword = randomAlphanumeric(8);


    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(chrome);
        WelcomePage welcomepage = loginPage.loginToApp(validLogin, validPassword);
        Assert.assertTrue(welcomepage.isSideBarDisplayed(), "Side Bar is not displayed");
        loginPage = welcomepage.logout();
        Assert.assertTrue(loginPage.isForgotPasswordButtonDisplayed(), "Login Page is not displayed");
    }

    @Test
    public void loginWithInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(chrome);
        WelcomePage welcomePage = loginPage.loginToApp(validLogin, invalidPassword);
        Assert.assertTrue(loginPage.isErrorMessageForIncorrectCredentialsDisplayed(), "No error message is displayed");
        assertThat(loginPage.getTextFromErrorMessage(), anyOf(containsString("Password or email are incorrect"), containsString("Некорректный пароль или email")));
    }


}
