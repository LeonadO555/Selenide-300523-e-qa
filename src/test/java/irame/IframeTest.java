package irame;

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
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://demoqa.com/frames");

        String expectedHeadingTest = "This is a sample page";

        iframe = new Iframe();
        String bigHeadingText = iframe.getSampleHeadingBig();
        assertEquals(bigHeadingText, expectedHeadingTest, bigHeadingText + "is not equal" + expectedHeadingTest);
        switchTo().defaultContent();
        String smallHeadingText = iframe.getSampleHeadingSmall();
        assertEquals(smallHeadingText, expectedHeadingTest, smallHeadingText + "is not equal" + expectedHeadingTest);

        closeWebDriver();
    }
}
