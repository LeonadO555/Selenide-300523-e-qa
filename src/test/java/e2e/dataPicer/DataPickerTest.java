package e2e.dataPicer;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import e2e.elements.DataPickerCalendar;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DataPickerTest {
    DataPickerCalendar dataPickerCalendar;

    @Test
    public void dataPickerCalendar() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://demoqa.com/date-picker");
        LocalDate date = LocalDate.of(2023, 6, 25);

        dataPickerCalendar = new DataPickerCalendar($x("//*[@id ='datePickerMonthYearInput']"));
        dataPickerCalendar.setData(date);

        Selenide.closeWebDriver();
    }
}
