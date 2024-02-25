package e2e.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Iframe {

    SelenideElement firstWrapper = $x("//*[@id='frame1Wrapper']");
    SelenideElement secondWrapper = $x("//*[@id='frame2Wrapper']");

    public String getSampleHeadingBig() {
        firstWrapper.scrollIntoView(true);
        WebDriver bigIframe = switchTo().frame("frame1");
        return bigIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    }

    public String getSampleHeadingSmall() {
        secondWrapper.scrollIntoView(true);
        WebDriver smallIframe = switchTo().frame("frame2");
        return smallIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    }
}
