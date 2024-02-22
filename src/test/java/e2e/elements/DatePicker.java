package e2e.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$x;

public class DatePicker {
    private SelenideElement input;
    private SelenideElement body = $x("//*[@class='react-datepicker']");
    private SelenideElement currentDate = body.find("//*[contains(@class,'react-datepicker__current-month')]");
    private SelenideElement selectMonth = body.find("//*[@class='react-datepicker__month-select']");
    private SelenideElement selectYear = body.find("//*[@class='react-datepicker__year-select']");
    private SelenideElement leftArrow = body.find("//*[@aria-label='Previous Month']");
    private SelenideElement rigtArrow = body.find("//*[@aria-label='Next Month']");


    public DatePicker(SelenideElement input) {
        this.input = input;
    }


    public void setDate(Date date) {
//        int monthNumber = date.getMonth();
//        Month month = Month.of(monthNumber);
//        month.name();
        input.shouldBe(Condition.visible);
        input.shouldBe(Condition.enabled);
        input.click();

        body.shouldBe(Condition.visible);
        currentDate.shouldBe(Condition.visible);
        String currentMonthAndYear = currentDate.getText();
        String[] parse = currentMonthAndYear.split(" ");
        String month = parse[0];
        String year = parse[1];
        int monthNumber = Month.valueOf(month).getValue();
        int monthDiff = (date.getYear() - Integer.parseInt(year)) * 12 + (date.getMonth() - monthNumber);
        for (int i = 0; i < monthDiff; i++) {
            if (monthNumber > 0) {
                rigtArrow.click();
            } else {
                leftArrow.click();
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        String formattedDate = formatter.format(date);
        String dateWithOutSuffix = formattedDate.replaceAll("(\\d+)(st|nd|rd|th)", "$1");
        SelenideElement dayCell = $x("//*[contains(@aria-label, '" + dateWithOutSuffix + "')]");
    }
}
