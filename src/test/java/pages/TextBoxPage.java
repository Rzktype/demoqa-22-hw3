package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    SelenideElement mainHeaderText = $(".main-header"),
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressTextArea = $("#currentAddress"),
            permanentAddressTextArea = $("#permanentAddress"),
            submitButton = $(".btn-primary"),
    resultBlock = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        mainHeaderText.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressTextArea.setValue(value);
        return this;
    }
    public TextBoxPage clickButton() {
        submitButton.click();
        return this;
    }
    public TextBoxPage checkResult(String value) {
        resultBlock.shouldHave(text(value));
        return this;}
}

