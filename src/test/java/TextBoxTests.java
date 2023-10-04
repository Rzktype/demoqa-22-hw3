import org.junit.jupiter.api.Test;
import pages.components.ChecksOutputInfoComponent;

public class TextBoxTests extends tests.TestBase {


    @Test
    void fillFormTest() {
        ChecksOutputInfoComponent checkOutput = new ChecksOutputInfoComponent();
// test
        textBoxPage.openPage()
                .setUserName("Dmitry Volkov")
                .setUserEmail("DmitryVolkov@mail.ru")
                .setCurrentAddress("Moscow")
                .setPermanentAddress("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028")
                .clickButton();
// checks
        checkOutput.checkOutputResult("Name", "Dmitry Volkov")
                .checkOutputResult("Email", "DmitryVolkov@mail.ru")
                .checkOutputResult("Current Address", "Moscow")
                .checkOutputResult("Permananet Address", "Yekaterinburg");


    }
}