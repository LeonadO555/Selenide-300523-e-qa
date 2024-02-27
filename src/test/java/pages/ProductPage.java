package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    SelenideElement inventoryContainer = $("[class='inventory_details_container']");
    SelenideElement nameCart = $("[class='inventory_details_name large_size']");
    SelenideElement detailsPrice = $("[class='inventory_details_price']");
    SelenideElement backToProductsButton = $("[id='back-to-products']");
    SelenideElement shoppingCartLinkButton = $("[class='shopping_cart_link']");

    public void waitForVisibility() {
        inventoryContainer.shouldBe(visible);
    }

    public String getNameCart() {
        return nameCart.shouldBe(visible).text();
    }

    public String getDetailsPrice() {
        return detailsPrice.shouldBe(visible).text();
    }

    public void clickAddToCart(String productName) {
        SelenideElement addCartButton = $("[data-test='add-to-cart-" + productName.replace(" ", "-").toLowerCase() + "']");
        addCartButton.shouldBe(visible, enabled)
                .shouldHave(text("Add to cart"))
                .click();

    }

    public void clickRemoveFromCart(String productName) {
        SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
        removeButton.shouldBe(visible, enabled)
                .shouldHave(text("Remove"))
                .click();
    }

    public void clickBackToProducts() {
        backToProductsButton.click();
    }

    public void clickShoppingCartLink() {
        shoppingCartLinkButton.click();
    }
}
