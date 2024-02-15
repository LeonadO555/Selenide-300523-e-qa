package e2e.login;

import e2e.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    String password = "secret_sauce";

    public void positiveTestMethod(String username) {
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as standard_user with valid password")
    public void loginAsStandardUser() {
        positiveTestMethod("standard_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("1")
    @Test(description = "Login as standard_user with valid password")
    public void loginAsProblemUser() {
        positiveTestMethod("problem_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as standard_user with valid password")
    public void loginAsPerformanceGlitchUser() {
        positiveTestMethod("performance_glitch_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as standard_user with valid password")
    public void loginAsErrorUser() {
        positiveTestMethod("error_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as standard_user with valid password")
    public void loginAsVisualUser() {
        positiveTestMethod("visual_user");
    }

}
