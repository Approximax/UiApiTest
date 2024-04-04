package pages;

import com.codeborne.selenide.SelenideElement;
import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    SelenideElement profileName = $("#userName-value"),
            noRowsSign = $(".rt-noData");

    public ProfilePage openProfile() {
        open("/profile");

        return this;
    }

    public ProfilePage checkUserItemsInTheProfile() {
        noRowsSign.shouldBe(visible);

        return this;
    }

    public ProfilePage checkUserNameInProfile() {
        UserConfig userConfig = ConfigFactory.create(UserConfig.class);
        profileName.shouldHave(text(userConfig.getUserName()));

        return this;
    }
}
