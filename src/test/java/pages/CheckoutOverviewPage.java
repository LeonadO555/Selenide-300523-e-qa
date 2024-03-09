package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutOverviewPage {
    SelenideElement finishButton = $x("//*[@id='finish']");
    SelenideElement cancelButton = $x("//*[@id='cancel']");
    SelenideElement totalPrice = $("[class='summary_info_label summary_total_label'][text()='Total: $']");
    SelenideElement inventoryItemPrice = $("[class='inventory_item_price'][text()='29.99']");


    public String getItemPrice() {
        return inventoryItemPrice.text();
    }

    public void totalPrice() {
        totalPrice.shouldBe(visible);
    }

    public void clickOnFinishButton() {
        finishButton.shouldBe(visible).click();
    }

    public void clickOnCancelButton() {
        cancelButton.shouldBe(visible).click();
    }
}
