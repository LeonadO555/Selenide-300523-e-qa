package e2e.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class IFrame {

    SelenideElement firstWrapper = $x("//*[@id='frame1Wrapper']");
    SelenideElement secondWrapper = $x("//*[@id='frame2Wrapper']");

    private void scrollBottom() {
        JavascriptExecutor ja = (JavascriptExecutor) webdriver().driver().getWebDriver();
        ja.executeScript("window.scrollBy(0,500)", "");
    }

    public String getSampleHeadingBig() {
        firstWrapper.scrollIntoView(false);
        WebDriver bigIframe = switchTo().frame("frame1");
        return bigIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    }


    public String getSampleHeadingSmall() {
        scrollBottom();
        WebDriver smallIframe = switchTo().frame("frame2");
        return smallIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    }
}
