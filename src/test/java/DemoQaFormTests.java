import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.UserInfoPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        // Configuration.holdBrowserOpen = false;
    }

    UserInfoPage userInfoPage = new UserInfoPage();

    @Test
    void fillFormTest() {
        userInfoPage.openPage()
                .setFirstName("Dmitry")
                .setLastName("Volkov")
                .setUserEmail("DmitryVolkov@mail.ru")
                .setGender()
                .setUserNumber("9003030333")
                .setDateOfBirth("12", "August", "1993")
                .setSubjectsInput("Maths")
                .setHobbies("Sports")
                .setHobbies("Music")
                .UploadPicture("1.bmp")
                .setAdress("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028")
                        .setState("Haryana")
                                .setCity("Karnal")
                                        .clickSubmit();


        $("#uploadPicture").uploadFromClasspath("1.bmp");
        $("#currentAddress").setValue("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $(".btn-primary").click();

        // Checks
//        $(".table-responsive").shouldHave(
//                text("Dmitry Volkov"), // Check Student Name
//                text("DmitryVolkov@mail.ru"), // Check Student Email
//                text("Male"), // Check Gender
//                text("9003030333"), // Mobile Phone
//                text("12 August,1993"), // Check Date of Birth
//                text("Maths"), // Check Subjects
//                text("Sports, Music"), // Check Hobbies
//                text("1.bmp"), // Check Picture
//                text("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028"), // Check Address
//                text("Haryana Karnal")); // Check State and City
        userInfoPage.checkResult("Student Name", "Dmitry Volkov")
                .checkResult("Student Email", "DmitryVolkov@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9003030333");
    }
}
