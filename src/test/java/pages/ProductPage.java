package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    SelenideElement inventoryDetails = $("[class='inventory_details']");
    SelenideElement inventoryDetailsImg = $("[class='inventory_details_img']");
    SelenideElement inventoryItemContainer = $("[class='inventory_details_desc_container']");
    SelenideElement nameCart = $("[class='inventory_details_name large_size']");
    SelenideElement inventoryItemPrice = $("[class='inventory_details_price']");
    SelenideElement addToCart = $("[id='add-to-cart-sauce-labs-backpack']");
    SelenideElement backToProducts = $("[id='back-to-products']");
    SelenideElement shoppingCartLink = $("[class='shopping_cart_link']");
    SelenideElement removeItem = $("[class='remove-sauce-labs-backpack']");


    public String getItemPrice() {
        waitForVisibility();
        return inventoryItemPrice.text();
    }

    public String getNameCartText() {
        return nameCart.getText();
    }

    public void waitForVisibility() {
        inventoryItemContainer.shouldBe(visible);
    }


    public void clickAddToCart(String productName) {
        SelenideElement addCartButton = $("[data-test='add-to-cart-" + productName.replace(" ", "-").toLowerCase() + "')]");
        addCartButton.shouldBe(visible, enabled, editable)
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
        waitForVisibility();
        backToProducts.click();
    }


}
