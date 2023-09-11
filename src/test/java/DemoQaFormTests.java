import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class DemoQaFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
        @Test
             void fillFormtest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Dmitry");
        $("#lastName").setValue("Volkov");
        $("#userEmail").setValue("DmitryVolkov@mail.ru").pressEnter();
        $(".custom-control-label").click();
        $("#userNumber").setValue("9003030333");
        $("#dateOfBirthInput").click();           //setValue("10.11.1990").pressEnter(); не знаю как просто ввести ?//
        $(".react-datepicker__month-select").selectOption(5);
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("1.bmp");


            sleep(6000);
        }


}
