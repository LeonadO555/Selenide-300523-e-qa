package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    ElementsCollection inventoryItem = $$("[class='inventory_item']");
    ElementsCollection inventoryItemName = $$("[class='inventory_item_name ']");
    ElementsCollection inventoryItemNPrice = $$("[class='inventory_item_price']");
    SelenideElement shoppingCartLink = $("[class='shopping_cart_link']");

    public void openCartPage(){
        shoppingCartLink.shouldBe(visible,enabled)
                .click();
    }
    // цикл перебирает пока в массиве не закончится значения
    public void openProductPage(String[] productNames) {
        for (String productName:productNames) {
            $(new ByText(productName)).shouldHave(text(productName))
                    .shouldBe(visible).click();

        }
    }

    // получаем ко во позиций, карточек(6)б i это изначально 0, будет плюсоваться +1 ... и так до 6
    public void waitForVisibilityAllItems(){
        int numberOfItem = inventoryItem.size();
        for (int i = 0; i < numberOfItem; i++) {
            inventoryItem.get(i).shouldBe(visible);
        }
    }

    public String[] getAllItemName(){
        waitForVisibilityAllItems(); // проверяем, что хотя бы 1 виден
        return inventoryItemName.texts().toArray(new String[0]); // первое из массива будет начинаться с нуля

    }

    public String[] getAllItemPrice() {
        waitForVisibilityAllItems();
        return inventoryItemNPrice.texts().toArray(new String[0]);
        }

    public void clickAddToCart(String[] productNames) {
        for (String productName : productNames) {
            SelenideElement addCartButton = $("[data-test='add-to-cart-" + productName.replace(" ", "-").toLowerCase() + "']");
            addCartButton.shouldBe(visible, enabled)
                    .shouldHave(text("Add to cart"))
                    .click();
        }
    }
        public void clickRemoveFromCart(String[] productNames) {
            for (String productName : productNames) {
                SelenideElement removeButton = $("[data-test='remove-" + productName.replace(" ", "-").toLowerCase() + "']");
                removeButton.shouldBe(visible, enabled)
                        .shouldHave(text("Remove"))
                        .click();
            }
        }
    }

