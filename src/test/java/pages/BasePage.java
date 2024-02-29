package pages;

import com.codeborne.selenide.SelenideElement;
import e2e.enums.SideBarInfo;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class BasePage {

    Header header;
    SideBar sideBar;

    public BasePage() {
        this.header = new Header();
        this.sideBar = new SideBar();
    }
}

class Header {

    private final SelenideElement burgerMenu = $x("//*[@id='react-burger-menu-btn']");
    private final SelenideElement logo = $x("//*[@class='app_logo']");
    private final SelenideElement closButton = $x("//*[@id='react-burger-cross-btn']");
    SelenideElement shoppingCartLink = $("[class=shopping_cart_link']");

    public String getLogoText() {
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

class SideBar {
    public void goToSideBarOption(SideBarInfo tab) {
        SelenideElement sideBar = $x("//*[@id='" + tab.value + "_sidebar_link']");
        sideBar.shouldBe(visible).click();
    }
}
