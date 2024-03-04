package e2e;

import org.testng.annotations.Test;
import pages.*;

public class UserCanBuyProductsTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductPage productPage;
    YourCartPage yourCartPage;
    YourInformationPage yourInformationPage;
    OverviewPage overviewPage;

    @Test(description = "User can buy products")

    public void userCanBuyProducts() {
        String username = "Standard_user";
        String password = "secret_sauce";
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();

        productsPage = new ProductsPage();
        productsPage.waitForVisibilityAllItems();
        String[] productName = productsPage.getAllItemName();

        String[] productsAddToProductsPage = new String[]{productName[0], productName[1], productName[2]};
        productsPage.clickAddToCart(productsAddToProductsPage);

        String[] productsRemoveToProductsPage = new String[]{productName[2]};
        productsPage.clickRemoteToCart(productsRemoveToProductsPage);

        String productRemoveToProductPage = String.valueOf(productName[0]);
        productsPage.openProductPage(productRemoveToProductPage);

        productPage = new ProductPage();
        productPage.clickRemoveFromCart(productRemoveToProductPage);

        productPage.clickOnGoBackToProductButton();

        String productAddToProductPage = String.valueOf(productName[3]);
        productsPage = new ProductsPage();
        productsPage.openProductPage(productAddToProductPage);

        productPage = new ProductPage();
        productPage.clickAddToCartOnProductPage(productAddToProductPage);

        productsPage.openCartPage();


    }
}
