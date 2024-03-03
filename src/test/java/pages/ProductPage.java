package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    SelenideElement inventoryItemContainer = $("[class='inventory_details_container']");
    SelenideElement inventoryItemNameOnProductPage = $("[class='inventory_details_name large_size']");
    SelenideElement inventoryItemDescriptionOnProductPage = $("[class='inventory_details_desc large_size']");
    SelenideElement inventoryItemPrice = $("[class='inventory_details_price']");
    SelenideElement shoppingCartLink = $("[class='shopping_cart_link']");
    SelenideElement goToProductPage = $("[id='back-to-products']");

    public void clickAddToCartOnProductPage(String productName) {
        SelenideElement addCartButton = $("[data-test='add-to-cart-" + productName.replace(" ", "-").toLowerCase() + "']");
        addCartButton.shouldBe(visible, enabled).shouldHave(text("Add to cart")).click();
    }

    public void clickRemoveFromCart(String productName) {
        SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
        removeButton.shouldBe(visible, enabled)
                .shouldHave(text("Remove"))
                .click();
    }

    public String getItemPrice() {
        waitForVisibility();
        return inventoryItemPrice.text();
    }

    public String getItemName() {
        return inventoryItemNameOnProductPage.text();
    }

    public void waitForVisibility() {
        inventoryItemContainer.shouldBe(visible);
    }

    public void clickOnGoBackToProductButton() {
        goToProductPage.shouldBe(visible).click();
    }


}
