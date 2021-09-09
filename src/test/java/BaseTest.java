import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected Properties properties = new Properties();

    {
        try {
            properties.load(new FileInputStream("src/test/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String BASE_URL = properties.getProperty("baseUrl");

    @BeforeAll
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.headless = true;
        Configuration.timeout = 15000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}

