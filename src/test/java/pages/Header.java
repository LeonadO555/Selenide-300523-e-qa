package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header {

    private final SelenideElement burgerMenu = $x("//*[@id='react-burger-menu-btn']");
    private final SelenideElement logo = $x("//*[@class='app_logo']");
    private final SelenideElement closButton = $x("//*[@id='react-burger-cross-btn']");
    SelenideElement shoppingCartLink = $("[class=shopping_cart_link']");

    public String getLogoText() {
        logo.shouldBe(visible)
                .shouldHave();
        return logo.getText();
    }

    public void openBurgerMenu() {
        burgerMenu.shouldBe(visible)
                .click();
    }

    public void closBurgerMenu() {
        closButton.shouldBe(visible)
                .click();
    }

    public void openCartPage() {
        shoppingCartLink.shouldBe(visible, enabled)
                .click();
    }
}
