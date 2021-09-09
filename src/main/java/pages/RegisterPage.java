package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getDateNow;

public class RegisterPage {

    private SelenideElement
            emailField = $x("//input[@name=\"email\"]"),
            password = $x("//input[@name=\"password\"]"),
            blogName = $x("//input[@name=\"blogName\"]"),
            registerLink = $x("//span[contains(., \"Зарегистрироваться\")]"),
            policyLink = $x("//a[contains(., \"Terms of Service\")]"),
            termsOfServiceTitle = $x("//span[@class=\"title\"]"),
            age = $x("//input[@name=\"age\"]"),
            nextLink = $x("//span[contains(., \"Далее\")]");

    public void registerNewUser(String email) {
        emailField.setValue(email);
        password.setValue("Qwaszqwasz1234");
        blogName.setValue("MyPerfectBlog" + getDateNow());
        registerLink.click();
    }

    public void checkPolicy() {
        policyLink.click();
        switchTo().window(1);
        termsOfServiceTitle.shouldHave(text("Terms of Service"));
        closeWindow();
        switchTo().window(0);
    }

    public void enterAge() {
        age.setValue("34");
        nextLink.click();
    }
}
