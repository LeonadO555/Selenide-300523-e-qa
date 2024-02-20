package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage extends BasePage {

    private final SelenideElement addProductsButton = $x("//*[@id='item_4_title_link']");
    private final SelenideElement addToCartButton = $x("//*[@class='btn btn_primary btn_small btn_inventory']");
    private final SelenideElement loginButton = $x("//*[@id='login-button']");

    public void product() {
        addProductsButton.pressTab();


    }

    public void cart() {
        addToCartButton.click();
    }

}


