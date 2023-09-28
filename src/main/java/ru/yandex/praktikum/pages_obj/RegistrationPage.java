package ru.yandex.praktikum.pages_obj;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public class RegistrationPage {
    private final SelenideElement namePlaceholder = $(byXpath(".//label[text() = 'Имя']/following-sibling::input"));
    private final SelenideElement emailPlaceholder = $(byXpath(".//label[text() = 'Email']/following-sibling::input"));
    private final SelenideElement passwordPlaceholder = $(byXpath(".//label[text() = 'Пароль']/following-sibling::input"));
    private final SelenideElement registrationButton = $(byXpath(".//button[text() = 'Зарегистрироваться']"));
    private final SelenideElement errorPasswordWarning = $(byXpath(".//p[@class = 'input__error text_type_main-default']"));
    private final SelenideElement enterButton = $(byXpath(".//a[text() = 'Войти']"));
    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));

    @Step("Заполнить Имя")
    public RegistrationPage setName(String name) {
        namePlaceholder.setValue(name);
        return this;
    }
    @Step("Заполнить адрес электронной почты")
    public RegistrationPage setEmail(String email) {
        emailPlaceholder.setValue(email);
        return this;
    }

    @Step("Заполнить пароль")
    public RegistrationPage setPassword(String password) {
        passwordPlaceholder.setValue(password);
        return this;
    }

    @Step("нажать кнопку Зарегистрироваться")
    public RegistrationPage clickRegistration() {
        registrationButton.click();
        return this;
    }
    @Step("нажать кнопку Войти")
    public RegistrationPage clickEnterButton() {
        enterButton.click();
        return this;
    }
    @Step("ошибка некорректный пароль")
    public RegistrationPage errorPassword() {
        errorPasswordWarning.shouldHave(Condition.text("Некорректный пароль"));
        return this;
    }

    @Step("Проверка перехода на страницу входа")
    public RegistrationPage checkLoginPage() {
        Assert.assertThat(enterText.getText(), containsString("Вход"));
        return this;
    }
}