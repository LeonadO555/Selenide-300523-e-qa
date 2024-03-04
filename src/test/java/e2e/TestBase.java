package e2e;

//import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeMethod
    public void init() {
        WebDriverManager.chromedriver().setup();
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.reportsFolder = "test-result/reports";
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
