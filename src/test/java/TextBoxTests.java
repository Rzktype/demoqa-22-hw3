import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends tests.TestBase {


    @Test
    void fillFormTest() {
// test
        textBoxPage.openPage()
                .setUserName("Dmitry Volkov")
                .setUserEmail("DmitryVolkov@mail.ru")
                .setCurrentAddress("Moscow")
                .setPermanentAddress("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028")
                .clickButton();
// checks
        textBoxPage.checkResult("Dmitry Volkov")
                .checkResult("DmitryVolkov@mail.ru")
                .checkResult("Moscow")
                .checkResult("Yekaterinburg");


    }
}