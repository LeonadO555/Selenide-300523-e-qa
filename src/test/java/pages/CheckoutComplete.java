package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutComplete {

    SelenideElement completeHeader = $("[class='complete-header'][text()='Thank you for your order!']");
    SelenideElement backHomeButton = $("[class='btn btn_primary btn_small']");

    public String getItemPrice() {
        return completeHeader.text();
    }

    public void clickOnFinishButton() {
        backHomeButton.shouldBe(visible).click();
    }
}
