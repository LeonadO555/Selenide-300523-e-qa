package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YourCardPage {
    ElementsCollection inventoryItemOnYourCardPage = $$("[class='cart_item']");
    ElementsCollection inventoryItemNameOnYourCardPage = $$("[class='inventory_item_name']");
    ElementsCollection inventoryItemPrice = $$("[class='inventory_item_price']");
    SelenideElement checkoutButton = $("[id='checkout']");
    SelenideElement continueShoppingButton = $("[id='continue-shopping']");

    public void clickRemoveFromCart(String[] productNames) {
        for (String productName : productNames) {
            SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
            removeButton.shouldBe(visible, enabled).shouldHave(text("Remove")).click();
        }
    }

    public String[] getAllItemName() {
        waitFroVisibilityAllItems();
        return inventoryItemNameOnYourCardPage.texts().toArray(new String[0]);
    }

    public String[] getAllItemPrice() {
        waitFroVisibilityAllItems();
        return inventoryItemPrice.texts().toArray(new String[0]);
    }

    public void waitFroVisibilityAllItems() {
        int numberOfItem = inventoryItemOnYourCardPage.size();
        for (int i = 0; i < numberOfItem; i++) {
            inventoryItemOnYourCardPage.get(i).shouldBe(visible);
        }
    }

    public void waitFroInVisibilityAllItems() {
        int numberOfItem = inventoryItemOnYourCardPage.size();
        for (int i = 0; i < numberOfItem; i++) {
            inventoryItemOnYourCardPage.get(i).shouldBe(hidden);
        }
    }

    public void clickOnCheckoutButton() {
        checkoutButton.shouldBe(visible);
        checkoutButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.shouldBe(visible);
        checkoutButton.click();
    }
}
