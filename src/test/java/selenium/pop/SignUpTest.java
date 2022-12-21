package selenium.pop;

import com.altkom.framework.TestBase;
import com.altkom.pages.LoginPage;
import com.altkom.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {

    @Test
    public void signUpTest() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isSignupLoginButtonVisible(), "Sign in/Sign up button is not visible");
        mainPage.clickSignupLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.nameField.sendKeys("test_user");
        loginPage.emailField.sendKeys("test123@test.pl");
        loginPage.signUpButton.click();
    }
}
