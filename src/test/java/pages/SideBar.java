package pages;

import com.codeborne.selenide.SelenideElement;
import e2e.enums.SideBarInfo;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SideBar {
    public void goToSideBarOption(SideBarInfo tab) {
        SelenideElement sideBar = $x("//*[@id='" + tab.value + "_sidebar_link']");
        sideBar.shouldBe(visible).click();
    }
}
