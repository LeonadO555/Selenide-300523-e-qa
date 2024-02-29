package e2e.login;

import e2e.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    String password = "secret_sauce";

    public void positiveTestMethod(String username) {
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @AllureId("2")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as standard_user with valid password")
    public void loginAsStandardUser() {
        positiveTestMethod("standard_user");

        productsPage = new ProductsPage();


    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as problem_user with valid password")
    @AllureId("1")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as problem_user with valid password")
    public void loginAsProblemUser() {
        positiveTestMethod("problem_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as performance_glitch_user with valid password")
    @AllureId("4")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as performance_glitch_user with valid password")
    public void loginPerformanceGlitchUser() {
        positiveTestMethod("performance_glitch_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as error_user with valid password")
    @AllureId("3")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as error_user with valid password")
    public void loginErrorUser() {
        positiveTestMethod("error_user");
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as visual_user with valid password")
    @AllureId("5")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as visual_user with valid password")
    public void loginVisualUser() {
        positiveTestMethod("visual_user");
    }
}