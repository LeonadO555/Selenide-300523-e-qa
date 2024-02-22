package e2e.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class Iframe {

    SelenideElement firstWrapper = $x("//*[@id='frame1Wrapper']");
    SelenideElement secondWrapper = $x("//*[@id='frame2Wrapper']");

    public void scrollBottom() {
        JavascriptExecutor js = (JavascriptExecutor) webdriver().driver().getWebDriver();
        js.executeScript("window.scrollBy(0,900)", "");
    }
    //каждый фрэйм как вложенная страница!
    public  String getSampleHeadingBig(){
        firstWrapper.scrollIntoView(true);
        WebDriver bigIframe = switchTo().frame("frame1");
        return bigIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();

    }

    public  String getSampleHeadingSmall(){
        scrollBottom();
        WebDriver smallIframe = switchTo().frame("frame2");
        return smallIframe.findElement(By.xpath("//*[@id='sampleHeading']")).getText();



    }
}
