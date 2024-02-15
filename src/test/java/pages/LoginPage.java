package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement loginInput = $x("//*[@id='user-name']");
    private SelenideElement passwordInput = $x("//*[@id='password']");
    private SelenideElement loginButton = $x("//*[@id='login-button']");
    private SelenideElement loginCredentials = $x("//*[@id='login_credentials']");
    private SelenideElement loginPassword = $x("//*[@class='login_password']");


    @Step("Login as user with datausername:  {username} , password: {password}")
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
