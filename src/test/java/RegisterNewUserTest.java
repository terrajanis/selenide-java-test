import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.InterestsPage;
import pages.MainPage;
import pages.RegisterPage;

import static utils.RandomUtils.getRandomEmail;

public class RegisterNewUserTest extends BaseTest {


    @Test
    public void registerNewUser() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage(BASE_URL);
        mainPage.goToRegisterPage();

        RegisterPage registerPage = new RegisterPage();
        registerPage.checkPolicy();
        registerPage.registerNewUser(getRandomEmail());
        registerPage.enterAge();

        new InterestsPage().fillInterests();

        new DashboardPage().checkUserExists();

    }
}
