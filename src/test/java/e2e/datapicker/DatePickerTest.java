package e2e.datepicker;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import e2e.elements.DatePickerCalendar;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DatePickerTest {

    DatePickerCalendar datePickerCalendar;

    @Test
    public void datePickerCalendar() {
        // WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://demoqa.com/date-picker");

        LocalDate date = LocalDate.of(2023, 2, 25);
        datePickerCalendar = new DatePickerCalendar($x("//*[@id='datePickerMonthYearInput']"));
        datePickerCalendar.setDate(date);

        Selenide.closeWebDriver();
    }
}