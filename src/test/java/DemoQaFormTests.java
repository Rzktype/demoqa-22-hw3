import org.junit.jupiter.api.Test;
import pages.components.ChecksOutputInfoComponent;


public class DemoQaFormTests extends tests.TestBase {
    ChecksOutputInfoComponent tableUserInfo = new ChecksOutputInfoComponent();

    @Test
    void fillFormTest() {

        userInfoPage.openPage()
                .setFirstName("Dmitry")
                .setLastName("Volkov")
                .setUserEmail("DmitryVolkov@mail.ru")
                .setGender("Male")
                .setUserNumber("9003030333")
                .setDateOfBirth("12", "August", "1993")
                .setSubjectsInput("Maths")
                .setHobbies("Music")
                .UploadPicture("1.bmp")
                .setAddress("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();

        tableUserInfo.checkResult("Student Name", "Dmitry Volkov")
                .checkResult("Student Email", "DmitryVolkov@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9003030333")
                .checkResult("Date of Birth", "12 August,1993")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "1.bmp")
                .checkResult("Address", "620028")
                .checkResult("State and City", "Haryana Karnal");
    }
}
