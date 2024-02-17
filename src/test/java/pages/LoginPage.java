package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement loginInput = $x("//*[@id='user-name']");
    private SelenideElement passwordInput = $x("//*[@id='password']");
    private SelenideElement fieldsWithLoginData = $x("//*[@id='login_credentials']");
    private SelenideElement fieldsWithPasswordData = $x("//*[@class='login_password']");
    private SelenideElement loginButton = $x("//*[@id='login-button']");

    @Step("Login as user with data username:{username},password:{password}")
    public void login(String username, String password) {
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("Confirm login successful")
    public void confirmLogin() {
        fieldsWithLoginData.shouldNotBe(Condition.visible);//Entweder so oder so
        fieldsWithPasswordData.shouldBe(Condition.hidden);

    }

}
