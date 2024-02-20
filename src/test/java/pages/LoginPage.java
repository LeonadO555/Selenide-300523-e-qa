package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement userNameInput = $x("");
    private SelenideElement passwordInput = $x("");
    private SelenideElement loginInput = $x("");
    private SelenideElement textField = $x("");
}
