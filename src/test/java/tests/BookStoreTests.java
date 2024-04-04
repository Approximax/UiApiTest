package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import utils.extensions.WithLogin;

import static io.qameta.allure.Allure.step;

public class BookStoreTests extends TestBase {

    ProfilePage profilePage = new ProfilePage();

    @Test
    @DisplayName("Проверка пустого списка книг под авторизованным пользователем")
    @WithLogin
    void emptyBookList() {
        step("Открытие профиля пользователя", () -> {
            profilePage.openProfile();
        });

        step("Проверка профиля", () -> {
            profilePage.checkUserNameInProfile();
        });

        step("Проверка пустого списка", () -> {
            profilePage.checkUserItemsInTheProfile();
        });
    }
}
