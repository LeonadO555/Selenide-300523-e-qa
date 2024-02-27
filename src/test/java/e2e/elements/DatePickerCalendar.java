package e2e.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;

public class DatePickerCalendar {
    private final SelenideElement input;
    private final SelenideElement body = $x("//*[@class='react-datepicker']");
    private final SelenideElement currentDate = $x("//*[contains(@class,'react-datepicker__current-month')]");
    private final SelenideElement selectMonth = $x("//*[@class='react-datepicker__month-select']");
    private final SelenideElement selectYear = $x("//*[@class='react-datepicker__year-select']");
    private final SelenideElement leftArrow = $x("//*[@aria-label='Previous Month']");
    private final SelenideElement rightArrow = $x("//*[@aria-label='Next Month']");


    public DatePickerCalendar(SelenideElement input) {
        this.input = input;
    }

    public void setDate(LocalDate date) {
        input.shouldBe(Condition.visible, Condition.enabled).click();

        body.shouldBe(Condition.visible);
        currentDate.shouldBe(Condition.visible);

        String[] currentMothAndYear = currentDate.getText().split(" ");
        int currentMonth = Month.valueOf(currentMothAndYear[0].toUpperCase()).getValue();
        int currentYear = Integer.parseInt(currentMothAndYear[1]);
        int monthDiff = (date.getYear() - currentYear) * 12 + (date.getMonthValue() - currentMonth);
        for (int i = 0; i < Math.abs(monthDiff); i++) {
            if (monthDiff > 0) {
                rightArrow.click();
            } else {
                leftArrow.click();
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" MMMM dd ");
        String formattedDate = date.format(formatter);
        SelenideElement dayCell = $x("//*[contains(@aria-label , '" + formattedDate + "')]");

        currentDate.shouldHave(exactText(date.getMonth().name() + " " + date.getYear()));
        dayCell.click();
        body.shouldHave(Condition.hidden);
    }
}