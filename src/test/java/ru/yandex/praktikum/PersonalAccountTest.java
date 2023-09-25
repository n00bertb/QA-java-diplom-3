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

import static ru.yandex.praktikum.helpers.UserData.defaultUserData;
@DisplayName("Проверка личного кабинета")
public class PersonalAccountTest extends TestBase{
    private static User user;
    private final DeleteUser deleteUser = new DeleteUser();
    private final RegistrationUser registrationUser = new RegistrationUser();

    @Before
    public void setUp() {
        Configuration.headless = true;
        optionBrowser("chrome");
        user = defaultUserData();
        registrationUser.registrationUser();
    }

    @Test
    @DisplayName("Переход по клику на Личный кабинет")
    public void loginPersonalAccount() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin();
    }

    @Test
    @DisplayName("Переход по клику на Конструктор")
    public void transitionToConstructor() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin()
                .clickConstructorButton().checkTransitionMainPage();
    }

    @Test
    @DisplayName("Переход по клику на Stellar Burgers")
    public void transitionToLogo() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin()
                .clickLogoButton().checkTransitionMainPage();
    }

    @Test
    @DisplayName("Выход по кнопке Выйти в личном кабинете")
    public void exitFromPersonalAccount() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new AccountPage().checkSuccessfulAccountLogin()
                .clickExitButton().checkExitPersonalAccount();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        deleteUser.deleteDefaultUser();
    }
}