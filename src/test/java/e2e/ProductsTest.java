package e2e;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class ProductsTest extends TestBase {

    LoginPage loginPage;
    ProductsPage productsPage;
    YourCartPage yourCartPage;
    String password = "secret_sauce";
    String productName = "Product name";

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

    }
}