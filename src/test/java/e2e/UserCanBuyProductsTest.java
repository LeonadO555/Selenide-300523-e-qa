package e2e;

import org.testng.annotations.Test;
import pages.*;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;

public class UserCanBuyProductsTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductPage productPage;
    YourCartPage yourCartPage;
    YourInformationPage yourInformationPage;
    OverviewPage overviewPage;

    @Test(description = "User can buy products")
    public void userCanBuyProducts() {
        String username = "visual_user";
        String password = "secret_sauce";
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();

        productsPage = new ProductsPage();
        productsPage.waitForVisibilityAllItems();
        switchTo().alert().accept();
        String[] productNames = productsPage.getAllItemName();

        String[] productsAddToProductsPage = new String[]{productNames[0], productNames[1], productNames[2]};
        productsPage.clickAddToCart(productsAddToProductsPage);

        String[] productsRemoveToProductsPage = new String[]{productNames[2]};
        productsPage.clickRemoveToCart(productsRemoveToProductsPage);

        String productRemoveToProductPage = String.valueOf(productNames[0]);
        productsPage.openProductPage(productRemoveToProductPage);

        productPage = new ProductPage();
        productPage.clickRemoveFromCart(productRemoveToProductPage);

        productPage.clickOnGoBackToProductButton();

        String productAddToProductPage = String.valueOf(productNames[3]);
        productsPage = new ProductsPage();
        productsPage.openProductPage(productAddToProductPage);

        productPage = new ProductPage();
        String[] addedProducts = new String[]{productNames[1], productNames[3]};
        yourCartPage = new YourCartPage();
        String[] actualProducts = yourCartPage.getAllItemName();
        assertEquals(actualProducts, addedProducts, Arrays.toString(actualProducts) + " not equals" + Arrays.toString(addedProducts));
    }
}
