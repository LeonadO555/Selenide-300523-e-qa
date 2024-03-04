package e2e.Iframe;

import com.codeborne.selenide.Configuration;
import e2e.elements.IFrame;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
//import static org.testng.AssertJUnit.assertEquals;

public class IframeTest {

    IFrame iframe;

    @Test
    public void IframeTest() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://demoqa.com/frames");
        String expectedHeadingText = "This is a sample page";

        iframe = new IFrame();
        String bigHeadingText = iframe.getSampleHeadingBig();
        assertEquals(bigHeadingText, expectedHeadingText, bigHeadingText + "Is not equal" + expectedHeadingText);
        switchTo().defaultContent();
        String smallHeadingText = iframe.getSampleHeadingSmall();
        assertEquals(smallHeadingText, expectedHeadingText, smallHeadingText + "Is not equal" + expectedHeadingText);

        closeWebDriver();
    }

}
