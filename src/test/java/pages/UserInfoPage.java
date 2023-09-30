package pages;


import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class UserInfoPage {

    CalendarComponent calendar = new CalendarComponent();
    /// SelenideElements
    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $(".custom-control-label"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckboxes = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            stateDropDown = $("#react-select-3-input"),
            cityDropDown = $("#react-select-3-input"),
            submitButton = $(".btn-primary");


    public UserInfoPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public UserInfoPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public UserInfoPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public UserInfoPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public UserInfoPage setGender() {
        genderWrapper.click();
        return this;
    }

    public UserInfoPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public UserInfoPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate("12", "August", "1993");
//        $(".react-datepicker__month-select").selectOption(5);
//        $(".react-datepicker__year-select").selectOption("1993");
//        $(".react-datepicker__day--012").click();
        return this;
    }

    public UserInfoPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public UserInfoPage setHobbies(String value) {
        hobbiesCheckboxes.setValue(value).click();
        return this;
    }

    public UserInfoPage UploadPicture(String filename) {
        uploadPictureInput.uploadFromClasspath(filename);
        return this;
    }
    public UserInfoPage setAdress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }
public UserInfoPage setState(String value){
    stateDropDown.setValue(value);
    return this;
}
    public UserInfoPage setCity(String value){
        cityDropDown.setValue(value);
        return this;
    }
    public UserInfoPage clickSubmit(){
        submitButton.click();
        return this;
    }
    public UserInfoPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
