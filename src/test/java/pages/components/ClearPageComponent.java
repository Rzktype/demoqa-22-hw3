package pages.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ClearPageComponent {
    public void removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}