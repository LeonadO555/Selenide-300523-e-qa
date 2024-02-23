package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {
    ElementsCollection inventoryItem = $$("[class='inventory_item']");
    ElementsCollection inventoryItemName = $$("[class='inventory_item_name ']");
    ElementsCollection inventoryItemPrice = $$("[class='inventory_item_price']");

    SelenideElement shoppingCartLink = $("[class='shopping_cart_link']");

    public void openCartPage() {
        shoppingCartLink.shouldBe(visible, enabled).click();
    }

    public void openProductPage(String[] productNames) {
        for (String productName : productNames) {
            $(new ByText(productName)).shouldHave(text(productName)).shouldBe(visible).click();
        }
    }

    public void waitFroVisibilityAllItems() {
        int numberOfItem = inventoryItem.size();
        for (int i = 0; i < numberOfItem; i++) {
            inventoryItem.get(i).shouldBe(visible);
        }
    }

    public String[] getAllItemName() {
        waitFroVisibilityAllItems();
        return inventoryItemName.texts().toArray(new String[0]);
    }

    public String[] getAllItemPrice() {
        waitFroVisibilityAllItems();
        return inventoryItemPrice.texts().toArray(new String[0]);
    }

    public void clickAddToCart(String[] productNames) {
        for (String productName : productNames) {
            SelenideElement addCartButton = $("[data-test='add-to-cart-" + productName.replace(" ", "-").toLowerCase() + "']");
            addCartButton.shouldBe(visible, enabled).shouldHave(text("Add to cart")).click();
        }
    }

    public void clickRemoveFromCart(String[] productNames) {
        for (String productName : productNames) {
            SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
            removeButton.shouldBe(visible, enabled).shouldHave(text("Remove")).click();
        }
    }


}
