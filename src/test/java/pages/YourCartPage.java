package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YourCartPage {

    ElementsCollection listCartItems = $$("[class='cart_item']");
    ElementsCollection inventoryItemName = $$("[class='inventory_item_name']");
    ElementsCollection inventoryItemPrice = $$("[class='inventory_item_price']");
    SelenideElement checkoutButton = $("[id='checkout']");

    public void waitForVisibilityAllItems() {
        int numberOfItem = listCartItems.size();
        for (int i = 0; i < numberOfItem; i++) {
            listCartItems.get(i).shouldBe(visible);
        }
    }

    public String[] getAllItemName() {
        waitForVisibilityAllItems();
        return listCartItems.texts().toArray(new String[0]);
    }


    public String[] getNameCart() {
        waitForVisibilityAllItems();
        return inventoryItemName.texts().toArray(new String[0]);
    }

    public String[] getCartPrice() {
        waitForVisibilityAllItems();
        return inventoryItemPrice.texts().toArray(new String[0]);
    }

    public void clickRemoveFromCart(String productName) {
        SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
        removeButton.shouldBe(visible, enabled)
                .shouldHave(text("Remove"))
                .click();
    }

    public void clickContinueShopping(String productName) {
        SelenideElement continueShoppingButton = $("[data-test='continue-shopping-" + productName.replace(" ", "-").toLowerCase() + "']");
        continueShoppingButton.shouldBe(visible, enabled)
                .shouldHave(text("Continue-shopping"))
                .click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
