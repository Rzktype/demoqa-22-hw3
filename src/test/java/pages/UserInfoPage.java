package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class UserInfoPage {

    /// SelenideElements
    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $(".custom-control-label"),
            userNumberInput = $("#userNumber");

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


}
