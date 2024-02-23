package e2e.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class Iframe {
    SelenideElement firstWrapper = $x("//*[@id='frame1Wrapper']");
    SelenideElement secondWrapper = $x("//*[@id='frame2Wrapper']");

    public void scrollButton() {
        JavascriptExecutor js = (JavascriptExecutor) webdriver().driver().getWebDriver();
        js.executeScript("window.scrollBy(0,800)", "");
    }

    public String getSampleHeadingBig() {
        firstWrapper.scrollIntoView(true);
        WebDriver bigIframe = switchTo().frame("frame1");
        return bigIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    }


    public String getSampleHeadingSmall() {
        scrollButton();
        WebDriver smallIframe = switchTo().frame("frame2");
        return smallIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    }
}
