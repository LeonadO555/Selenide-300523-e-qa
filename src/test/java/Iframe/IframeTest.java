package e2e.Iframe;

import com.codeborne.selenide.Configuration;
import e2e.elements.Iframe;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;


public class IframeTest {

    Iframe iframe;

    @Test
    public void iframeTest() {

        // WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://demoqa.com/frames");

        String expectedHeadingTest = "This is a sample page";

        iframe = new Iframe();
        String bigHeadingTest = iframe.getSampleHeadingBig();
        assertEquals(bigHeadingTest, expectedHeadingTest, bigHeadingTest + " is not equal" + expectedHeadingTest);

        switchTo().defaultContent();

        String smallHeadingTest = iframe.getSampleHeadingSmall();
        assertEquals(smallHeadingTest, expectedHeadingTest, smallHeadingTest + " is not equal" + expectedHeadingTest);

        closeWebDriver();
    }
}