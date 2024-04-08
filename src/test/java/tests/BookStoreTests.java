package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import utils.extensions.WithLogin;

import static io.qameta.allure.Allure.step;

public class BookStoreTests extends TestBase {

    ProfilePage profilePage = new ProfilePage();

    @Test
    @Tag("emptyCheckout")
    @DisplayName("Проверка пустого списка книг под авторизованным пользователем")
    @WithLogin
    void emptyBookList() {
        step("Открытие прфилья пользователя с уже пройденной авторизацией", () -> {
            profilePage.openProfile();
        });

        step("Тетст открытия именно того профиля, чьи данные передавались на этапе авторизации", () -> {
            profilePage.checkUserNameInProfile();
        });

        step("Проверка отсутствия каких либо товаров в корзине по умолчанию", () -> {
            profilePage.checkUserItemsInTheProfile();
        });
    }
}
