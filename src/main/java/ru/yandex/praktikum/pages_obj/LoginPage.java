package ru.yandex.praktikum.pages_obj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public class LoginPage {
    private final SelenideElement registrationLink = $(byXpath(".//a[text() = 'Зарегистрироваться']"));
    private final SelenideElement emailPlaceholder = $(byXpath(".//label[text() = 'Email']/following-sibling::input"));
    private final SelenideElement passwordPlaceholder = $(byXpath(".//label[text() = 'Пароль']/following-sibling::input"));
    private final SelenideElement enterButton = $(byXpath(".//button[text() = 'Войти']"));
    private final SelenideElement createBurgerCheck = $(byXpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']"));

    @Step("Нажать на кнопку регистрации")
    public LoginPage clickRegistrationLink() {
        registrationLink.click();
        return this;
    }

    @Step("Заполнить email")
    public LoginPage setEmail(String email) {
        emailPlaceholder.setValue(email);
        return this;
    }

    @Step("Заполнить пароль")
    public LoginPage setPassword(String password) {
        passwordPlaceholder.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку входа")
    public LoginPage clickEnter() {
        enterButton.click();
        return this;
    }

    @Step("Проверка перехода на главную страницу")
    public LoginPage checkSuccessfulLogin() {
        Assert.assertThat(createBurgerCheck.getText(),containsString("Соберите бургер"));
        return this;
    }


}