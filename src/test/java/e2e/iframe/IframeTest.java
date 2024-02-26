package e2e.iframe;

import com.codeborne.selenide.Configuration;
import e2e.elements.Iframe;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;


public class IframeTest {

    Iframe iframe;

    @Test
    public void iframeTest() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notification");
        options.addArguments("--disable-notification");
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--disable-notification");
        open("https://demoqa.com/frames");
        String expectedHeadingText = "This is sample page";

        iframe = new Iframe();
        String bigHeadingText = iframe.getSampleHeadingBig();
        assertEquals(bigHeadingText, expectedHeadingText, bigHeadingText + "is not equal" + expectedHeadingText);

        String smallHeadingText = iframe.getSampleHeadingSmall();
        assertEquals(smallHeadingText, expectedHeadingText, smallHeadingText + "is not equal" + expectedHeadingText);

        closeWebDriver();
    }
}
