package e2e.login;

import e2e.TestBase;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourInformationPage;

public class ProductsTest extends TestBase {

    LoginPage loginPage;
    String password = "secret_sauce";

    YourInformationPage checkoutYourInformation;
    ProductsPage productsPage;


    public void positiveTestMethod(String username) {
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();
    }

    @Epic("login")
    @Feature("Positive login")
    @Description("Login as performance_glitch_user with valid password")
    @AllureId("4")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as performance_glitch_user with valid password")
    public void loginPerformanceGlitchUserUser() {
        positiveTestMethod("performance_glitch_user");

        String firstName = "Oksana";
        String lastName = "Tolok";
        String zipPostalCode = "22222";

        productsPage = new ProductsPage();
        productsPage.clickAddToCart();

        checkoutYourInformation = new YourInformationPage();
        checkoutYourInformation.yourInformation(firstName, lastName, zipPostalCode);
    }
}
