package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement loginInput = $x("//*[@id='user-name']");
    private SelenideElement passwordInput = $x("//*[@id='password']");
    private SelenideElement loginButton = $x("//*[@id='login-button']");
    private SelenideElement loginCredentials = $("[id='login_credentials']");
    private SelenideElement loginPassword = $x("//*[@class='login_password']");
    //private ElementsCollection aLotOfElementsXpath = $$x("//*[@class='login_password']");
    //private ElementsCollection aLotOfElementsCssSelector = $$("//*[@class='login_password']");

    /* private SelenideElement element = $(".myClass");
     private SelenideElement element = $("#myId");
     private SelenideElement element = $("input");
     private SelenideElement element = $("input[@='myId']");*/
    @Step("Login as user with data username: {username}, password:{password}")
    public void login(String username, String password) {
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("Confirm login successful")
    public void confirmLogin() {
        loginCredentials.shouldBe(Condition.hidden);
        loginPassword.shouldNotBe(Condition.visible);
    }
}
