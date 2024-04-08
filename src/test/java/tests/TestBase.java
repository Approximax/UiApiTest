package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverConfig;
import config.LinksConfig;
import config.UserConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attach;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);
        LinksConfig linksConfig = ConfigFactory.create(LinksConfig.class);
        UserConfig userConfig = ConfigFactory.create(UserConfig.class);

        String userName = userConfig.getUserName();

        Configuration.baseUrl = linksConfig.baseUrl();
        RestAssured.baseURI = linksConfig.baseUri();
        Configuration.browserSize = driverConfig.browserSize();
        Configuration.browser = driverConfig.browserName();
        Configuration.browserVersion = driverConfig.browserVersion();
        Configuration.timeout = 10000;
        Configuration.remote = linksConfig.selenoidUrl();
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}