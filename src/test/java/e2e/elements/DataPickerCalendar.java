package e2e.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$x;

public class DataPickerCalendar {
    private SelenideElement input;
    private SelenideElement body = $x("//*[@class='react-datepicker']");
    private SelenideElement currentData = $x("//*[contains(@class,'react-datepicker__current-month')]");
    private SelenideElement selectMonth = $x("//*[@class='react-datepicker__month-select']");
    private SelenideElement selectYear = $x("//*[@class='react-datepicker__year-select']");
    private SelenideElement leftArrow = $x("//*[@aria-label='Previous Month']");
    private SelenideElement rightArrow = $x("//*[@aria-label='Next Month']");

    public DataPickerCalendar(SelenideElement input) {
        this.input = input;
    }

    public void setData(LocalDate data) {
        input.shouldBe(Condition.visible, Condition.enabled).click();
        body.shouldBe(Condition.visible);
        currentData.shouldBe(Condition.visible);
        String[] currentMonthAndYear = currentData.getText().split(" ");
        int currentMonth = Month.valueOf(currentMonthAndYear[0].toUpperCase()).getValue();
        int currentYear = Integer.parseInt(currentMonthAndYear[1]);
        int monthDiff = (data.getYear() - currentYear) * 12 + (data.getMonthValue() - currentMonth);
        for (int i = 0; i < Math.abs(monthDiff); i++) {
            if (monthDiff > 0) {
                rightArrow.click();
            } else {
                leftArrow.click();
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd");
        String formattedData = data.format(formatter);
//        String dateWithoutSuffix = formattedData.replaceAll("(\\d+)(st|nd|rd|th)", "$1");//это регулярка
        SelenideElement dayCell = $x("//*[contains(@aria-label, '" + formattedData + "')]");
//        currentData.shouldHave(exactText(data.getMonth() + " " + data.getYear()));
        dayCell.click();
        body.shouldHave(Condition.hidden);
    }
}


