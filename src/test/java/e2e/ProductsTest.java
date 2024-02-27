package e2e;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourInformationPage;

public class ProductsTest extends ProductsPage {

    LoginPage loginPage;
    ProductsPage productsPage;
    YourInformationPage checkoutYourInformation;
    String password = "secret_sauce";

    public void positiveTestMethod(String username) {
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();
    }

    @Epic("Login")
    @Feature("Positive login")
    @Description("Login as standard_user with valid password")
    @AllureId("")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Login as standard_user with valid password")
    public void loginAsStandardUser() {
        positiveTestMethod("standard_user");

        String firstName = "Georgiy";
        String lastName = "Manolov";
        String zipPostalCode = "12345";

        productsPage = new ProductsPage();
        productsPage.clickAddToCart();

        checkoutYourInformation = new YourInformationPage();
        checkoutYourInformation.yourInformation(firstName, lastName, zipPostalCode);


    }
}