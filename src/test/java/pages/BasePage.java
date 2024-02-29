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
    SelenideElement shoppingCartLink = $("class='shopping_cart_link'");

    public void opencartPage() {
        shoppingCartLink.shouldBe(visible, enabled)
                .click();
    }
}

class SideBar {

    private final SelenideElement closButton = $x("//*[@id='react-burger-cross-btn']");

    public void goToSideBarOption(SideBarInfo tab) {
        SelenideElement sideBar = $x("//*[@id= + tab.value + '_sidebar_link']");
        sideBar.shouldBe(visible).click();

        //private final SelenideElement allItems = $x("//*[@id='inventory_sidebar_link']");
        //private final SelenideElement about = $x("//*[@id='about_sidebar_link']");
        //private final SelenideElement logout = $x("//*[@id='logout_sidebar_link']");
        //private final SelenideElement resetAppState = $x("//*[@id='reset_sidebar_link']");
    }
}
