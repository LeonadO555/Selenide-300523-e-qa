package e2e.iframe;

import com.codeborne.selenide.Configuration;
import e2e.elements.Iframe;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;


public class IframeTest {

    Iframe iframe;

    @Test
    public void iframeTest() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--disable-notification");
        open("https://demoqa.com/frames");

        String expectedHeadingText = "This is a sample page";

        iframe = new Iframe();
        String bigHeadingText = iframe.getSampleHeadingBig();
        assertEquals(bigHeadingText, expectedHeadingText, bigHeadingText + "is not equal" + expectedHeadingText);
        switchTo().defaultContent();

        String smallHeadingText = iframe.getSampleHeadingSmall();
        assertEquals(smallHeadingText, expectedHeadingText, smallHeadingText + "is not equal" + expectedHeadingText);

        closeWebDriver();
    }
}
