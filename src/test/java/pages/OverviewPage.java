package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.LinkedHashMap;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverviewPage extends ProductsPage {

    ElementsCollection overviewInventoryItemPrice = $$("[class='inventory_item_price ']");
    ElementsCollection overviewInventoryItemName = $$("[class='inventory_item_name ']");
    SelenideElement cancelButton = $("[id='cancel']");
    SelenideElement finishButton = $("[id='finish']");
    SelenideElement paymentInfo = $("[class='summary_info_label'][text()='Payment Information']");
    SelenideElement shippingInfo = $("[class='summary_info_label'][text()='Shipping Information']");
    SelenideElement itemTotal = $("[class='summary_subtotal_label']");
    SelenideElement tax = $("[class='summary_tax_label']");
    SelenideElement total = $("[class='summary_info_label summary_total_label']");

    public void clickCancelButton() {
        cancelButton.shouldBe(visible)
                .click();
    }

    public void clickFinishButton() {
        finishButton.shouldBe(visible)
                .click();
    }

    public LinkedHashMap<String, String[]> getAllIInfoPage() {
        String[] actualProductsName = overviewInventoryItemName
                .texts()
                .toArray(new String[0]);
        String[] actualProductsPrice = overviewInventoryItemPrice
                .texts()
                .toArray(new String[0]);
        String actualTotalProductsPrice = itemTotal
                .text();
        LinkedHashMap<String, String[]> itemInfoObjects = new LinkedHashMap<>();
        itemInfoObjects.put("productsName", actualProductsName);
        itemInfoObjects.put("productsPrice", actualProductsPrice);
        itemInfoObjects.put("itemTotalPrice", new String[]{actualTotalProductsPrice});
        return itemInfoObjects;
//        {“productsName:”: [ bla,bla],
//            “productPrice”: [la,la]}
    }

    //  public LinkedHashMap<String, String[]> getAllIInfoPage(OverviewPage page) {
    //        LinkedHashMap<String, String[]> itemInfoObjects = new LinkedHashMap<>();
    //        itemInfoObjects.put("productsName", overviewInventoryItemName
    //           .texts()
    //           .toArray(new String[0]));
    //        itemInfoObjects.put("productsPrice", overviewInventoryItemPrice
    //           .texts()
    //           .toArray(new String[0]));
    //        itemInfoObjects.put("itemTotalPrice", new String[]{itemTotal
    //          .text()});
    //        return itemInfoObjects;


    //        {“productsName:”: [ bla,bla],
    //            “productPrice”: [la,la]}
    //              "itemTotalPrice":[21516]
    public void checkPaymentInfo() {
        paymentInfo.shouldBe(visible);
    }

    public void shippingInfo() {
        shippingInfo.shouldBe(visible);
    }

}
