package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.TextBoxPage;
import pages.UserInfoPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {

    public UserInfoPage userInfoPage = new UserInfoPage();
    public TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }


    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

}