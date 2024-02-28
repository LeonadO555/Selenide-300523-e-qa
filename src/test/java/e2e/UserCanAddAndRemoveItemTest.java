package e2e;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPaga;
import pages.ProductsPage;
import pages.YourCardPage;

public class UserCanAddAndRemoveItemTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductPaga productPaga;
    YourCardPage yourCardPage;
    String username = "standard_user";
    String password = "secret_sauce";

    @Test
    public void userCanAddAndRemoveItemTest() {
        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();
        productsPage = new ProductsPage();
        productsPage.waitFroVisibilityAllItems();
        String[] allItemName = productsPage.getAllItemName();
        String[] allItemPrice = productsPage.getAllItemPrice();
        productsPage.clickAddToCart(allItemName);
        String[] itemToRemove = new String[]{allItemName[3], allItemName[0]};
        productsPage.clickRemoveFromCart(itemToRemove);
        String[] itemToRemoveOnProductPage = new String[]{allItemName[1]};
        productsPage.openProductPage(new String[]{allItemName[1]});
        productPaga = new ProductPaga();
        productPaga.waitForVisibility();
        String itemNameOnProductPage = productPaga.getItemName();
//        Assert.assertEquals(itemNameOnProductPage, itemToRemoveOnProductPage);
        productPaga.clickRemoveFromCartOnProductPage();
        productPaga.clickOnGoBackToProductButton();



    }
}
