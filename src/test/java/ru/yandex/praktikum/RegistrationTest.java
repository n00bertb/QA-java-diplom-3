package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pages_obj.*;
import ru.yandex.praktikum.helpers.*;
import ru.yandex.praktikum.models.*;

import static ru.yandex.praktikum.helpers.UserData.*;
@DisplayName("Проверка регистрации пользователя")
public class RegistrationTest extends TestBase{
    private User user;
    private final DeleteUser deleteUser = new DeleteUser();
    private boolean createUser;
    @Before
    public void setUp() {
        Configuration.headless = false;
        optionBrowser("chrome");
        Selenide.open("https://stellarburgers.nomoreparties.site/");
        new MainPage().clickPersonalAccountButton();
        new LoginPage().clickRegistrationLink();
    }
    @Test
    @DisplayName("Успешная регистрация профиля пользователя")
    public void registrationUser() {
        createUser = true;
        user = defaultUserData();
        new RegistrationPage()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickRegistration()
                .checkLoginPage();

    }

    @Test
    @DisplayName("Регистрация профиля пользователя с некорректным паролем")
    public void registrationUserWithIncorrectPassword() {
        createUser = false;
        user = userDataIncorrectPassword();
        new RegistrationPage()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickRegistration()
                .errorPassword();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        if (createUser) {
            deleteUser.deleteDefaultUser();
        }
    }
}