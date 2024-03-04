package e2e;


import e2e.enums.SideBarInfo;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;

import java.util.Arrays;
import java.util.LinkedHashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class UserCanBuyProductsTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage;
    ProductPage productPage;
    YourCartPage yourCartPage;
    YourInformationPage yourInformationPage;
    OverviewPage overviewPage;
    CheckoutPage checkoutPage;
    Header header;
    SideBar sideBar;

    @Epic(value = "user can buy products ")
    @Feature(value = "user can buy product")
    @Description(value = " user can buy products ")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("1")
    @Test(description = "User can buy products")
    public void userCanBuyProducts() {
        String username = "visual_user";
        String password = "secret_sauce";
        String firstName = "Georgiy";
        String lastName = "Manolov";
        String zipPostalCode = "13581";

        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();

        productsPage = new ProductsPage();
        productsPage.waitForVisibilityAllItems();
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
        productPage.clickAddToCartOnProductPage(productAddToProductPage);

        productsPage.openCartPage();
        String[] addedProducts = new String[]{productNames[1], productNames[3]};
        yourCartPage = new YourCartPage();
        String[] actualProducts = yourCartPage.getAllItemName();
        assertEquals(actualProducts, addedProducts, Arrays.toString(actualProducts) + " not equals" + Arrays.toString(addedProducts));
        yourCartPage.clickOnContinueShoppingButton();

        yourInformationPage = new YourInformationPage();
        yourInformationPage.setYourInformationForm(firstName, lastName, zipPostalCode);
        yourInformationPage.clickContinueButton();

        overviewPage = new OverviewPage();
        overviewPage.getAllIInfoPage();

        LinkedHashMap<String, String[]> itemInfo = overviewPage.getAllIInfoPage();
        assertNotNull(itemInfo);
        assertNotNull(itemInfo.get("productsName"));
        assertNotNull(itemInfo.get("productsPrice"));
        assertNotNull(itemInfo.get("itemTotalPrice"));

        overviewPage.clickFinishButton();

        checkoutPage = new CheckoutPage();
        checkoutPage.getAllCheckoutPage();
        LinkedHashMap<String, String[]> itemInfoObject = checkoutPage.getAllCheckoutPage();
        assertNotNull(itemInfoObject);
        assertNotNull(itemInfoObject.get("logo"));
        assertNotNull(itemInfoObject.get("Thank you for your order!"));
        assertNotNull(itemInfoObject.get("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        checkoutPage.clickBackHomeButton();

        productsPage = new ProductsPage();

        productsPage = new ProductsPage();
        productsPage.openCartPage();
        yourCartPage.clickOnContinueShoppingButton();

        header = new Header();
        header.openBurgerMenu();
        header.closBurgerMenu();
        header.getLogoText();
        header.openBurgerMenu();

        sideBar = new SideBar();
        sideBar.goToSideBarOption(SideBarInfo.ALLITEMS);

        header = new Header();
        header.openBurgerMenu();
        sideBar.goToSideBarOption(SideBarInfo.LOGOUT);

        loginPage = new LoginPage();
        loginPage.login(username, password);
        loginPage.confirmLogin();
    }
}