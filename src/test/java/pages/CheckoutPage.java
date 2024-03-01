package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.LinkedHashMap;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPage {

    ElementsCollection logo = $$("[class='pony_express']");
    ElementsCollection completeHeader = $$("[class='complete-header']");
    ElementsCollection completeText = $$("[class='complete-text']");
    SelenideElement backHomeButton = $("[id='back-to-products']");

    public LinkedHashMap<String, String[]> getAllCheckoutPage() {
        String[] imgLogo = logo
                .attributes("logo")
                .toArray(new String[0]);
        String[] actualTextName = completeHeader
                .texts()
                .toArray(new String[0]);
        String[] actualText2 = completeText
                .texts()
                .toArray(new String[0]);
        LinkedHashMap<String, String[]> itemInfoObjects = new LinkedHashMap<>();
        itemInfoObjects.put("logo", imgLogo);
        itemInfoObjects.put("Thank you for your order!", actualTextName);
        itemInfoObjects.put("Your order has been dispatched, and will arrive just as fast as the pony can get there!", actualText2);
        return itemInfoObjects;
    }

    public void clickBackHomeButton() {
        backHomeButton.shouldBe(visible, enabled)
                .shouldHave()
                .click();
    }

}
