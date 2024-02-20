package e2e.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;

public class DatePickerCalendar {
    private SelenideElement input;
    private SelenideElement body = $x("//*[@class='react-datepicker']");
    private SelenideElement currentDate = $x("//*[contains(@class,'react-datepicker__current-month')]");
    private SelenideElement selectMonth = $x("//*[@class='react-datepicker__month-select']");
    private SelenideElement selectYear = $x("//*[@class='react-datepicker__year-select']");
    private SelenideElement leftArrow = $x("//*[@aria-label='Previous Month']");
    private SelenideElement rightArrow = $x("//*[@aria-label='Next Month']");

    public DatePickerCalendar (SelenideElement input){
        this.input = input;
    }

//   public void setDate(){
//   for (Month month: Month.values()){
//   String monthName = month.name();
//   int monthNumber = month.getValue();
//   }

    public void setDate(LocalDate date){
//        int monthNumber = date.getMonth();
//        Month month = Month.of(monthNumber);
//        month.name();
        input.shouldBe(Condition.visible, Condition.enabled).click();

        body.shouldBe(Condition.visible);
        currentDate.shouldBe(Condition.visible);

        String[] currentMonthAndYear = currentDate.getText().split(" ");
//        Month currentMonth = Month.valueOf(currentMonthAndYear[0].toLowerCase());
//        String[] parse = currentMonthAndYear.split(" ");// разбивает по пробелу! на массив
//        String month = parse[0]; // достает по индексу
//        String year = parse[1];
//        int monthNumber = Month.valueOf(month).getValue();// преобразовали в число месяц
        int currentMonth = Month.valueOf(currentMonthAndYear[0].toUpperCase()).getValue();
        int currentYear = Integer.parseInt(currentMonthAndYear[1]);
        int monthDiff = (date.getYear() - currentYear) * 12 + (date.getMonthValue() - currentMonth);//число кликов, кот приведет до нужного месяца
        for (int i = 0; i < Math.abs(monthDiff); i++){
            if (monthDiff >0) {
                rightArrow.click();
            } else {
                leftArrow.click();
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd");
        String formattedDate = date.format(formatter);
        //String dateWithoutSuffix = formattedDate.replaceAll("(\\d+)(st|nd|rd|th)", "$1");// смотреть по всем словам и заменять любое число с таким окончанием на число без окончания,$  убирает это окнчание, заменяет на число
        SelenideElement dayCell = $x("//*[contains(@aria-label, '" + formattedDate + "')]");// contains  может содержать один из элементов указанных
        currentDate.shouldHave(exactText(date.getMonth() + " " + String.valueOf(date.getYear())));
        dayCell.click();
        body.shouldHave(Condition.hidden);
    }


}
