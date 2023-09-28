package ru.yandex.praktikum.pages_obj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public class AccountPage {
    private final SelenideElement profileNavButton = $(byXpath(".//a[text()='Профиль']"));
    private final SelenideElement constructorNavButton = $(byXpath(".//p[text()='Конструктор']"));
    private final SelenideElement exitNavButton = $(byXpath(".//button[text()='Выход']"));
    private final SelenideElement createBurgerCheck = $(byXpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']"));
    private final SelenideElement logoButton = $(byXpath("//div[@class='AppHeader_header__logo__2D0X2']/a"));
    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));

    @Step("нажать на кнопку профиля")
    public AccountPage clickProfileButton() {
        profileNavButton.click();
        return this;
    }
    @Step("нажать на кнопку конструктора")
    public AccountPage clickConstructorButton() {
        constructorNavButton.click();
        return this;
    }
    @Step("нажать кнопку выхода")
    public AccountPage clickExitButton() {
        exitNavButton.click();
        return this;
    }
    @Step("нажать на логотип")
    public AccountPage clickLogoButton() {
        logoButton.click();
        return this;
    }

    @Step("проверка аутентифицированного пользователя")
    public AccountPage checkSuccessfulAccountLogin() {
        Assert.assertThat(profileNavButton.getText(),containsString("Профиль"));
        return this;
    }
    @Step("Проверка перехода на главную страницу")
    public AccountPage checkTransitionMainPage() {
        Assert.assertThat(createBurgerCheck.getText(),containsString("Соберите бургер"));
        return this;
    }
    @Step("проверка выхода из личного кабинета")
    public AccountPage checkExitPersonalAccount() {
        Assert.assertThat(enterText.getText(),containsString("Вход") );
        return this;
    }
}