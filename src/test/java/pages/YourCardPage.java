package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YourCardPage {

    ElementsCollection listCartItems = $$("[class='cart_item']");

    SelenideElement continueShoppingButton = $("[id='continue-shopping']");
    SelenideElement checkoutButton = $("[id='checkout']");
    ElementsCollection itemPrice = $$("[class='inventory_item_price']");
    ElementsCollection itemName = $$("[class='inventory_item_name']");

    public String[] getItemPrice() {
        return itemPrice.shouldBe().texts().toArray(new String[0]);
    }

    public String getItemName() {
        return itemName.toString();
    }

    public void RemoveButtonIsVisible(String[] productNames) {
        for (String productName : productNames) {
            SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
            removeButton.shouldBe(visible, enabled)
                    .shouldHave(text("Remove"));
        }
    }
}
