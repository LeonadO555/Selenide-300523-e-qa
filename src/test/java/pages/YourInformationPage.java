package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class YourInformationPage extends ProductsPage {

    private final SelenideElement firstNameInput = $x("//*[@id='first-name']");
    private final SelenideElement lastNameInput = $x("//*[@id='last-name']");
    private final SelenideElement zipPostalCodeInput = $x("//*[@id='postal-code']");
    private final SelenideElement continueButton = $x("//*[@id='continue']");
    private final SelenideElement cancelButton = $x("//*[@id='cancel']");

    public void setYourInformationForm(String firstName, String lastName, String zipPostalCode) {
        firstNameInput.shouldBe(visible, enabled, editable)
                .setValue(firstName)
                .shouldHave(value(firstName));
        lastNameInput.shouldBe(visible, enabled, editable)
                .setValue(lastName)
                .shouldHave(value(lastName));
        zipPostalCodeInput.shouldBe(visible, enabled, editable)
                .setValue(zipPostalCode)
                .shouldHave(value(zipPostalCode));

    }


    public void clickContinueButton() {
        continueButton.shouldBe(visible, enabled)
                .shouldHave()
                .click();
    }
}
