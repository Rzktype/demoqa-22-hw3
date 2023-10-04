package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ChecksOutputInfoComponent {
    SelenideElement tableInfo = $(".table-responsive");
    SelenideElement output = $("#output");

    public ChecksOutputInfoComponent checkResult(String key, String value) {
        tableInfo.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public ChecksOutputInfoComponent checkOutputResult(String key, String value) {
        output.shouldHave(text(key), text(value));
        return this;
    }
}

