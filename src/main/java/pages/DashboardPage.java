package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private SelenideElement accountButton = $x("//button[@aria-label=\"Учетная запись\"]");

    public void checkUserExists(){
        accountButton.shouldBe(Condition.visible);
    }
}
