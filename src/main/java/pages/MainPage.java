package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement registerLink = $x("//a[contains(., \"Зарегистрироваться\")]");

    public void goToRegisterPage() {
        registerLink.click();
    }

    public void openMainPage(String url) {
        open(url);
    }
}
