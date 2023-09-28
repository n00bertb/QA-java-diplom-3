package ru.yandex.praktikum.pages_obj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class MainPage {
    private final SelenideElement personalAccountButton = $(byXpath(".//p[text()='Личный Кабинет']"));
    private final SelenideElement sauceButton = $(byXpath(".//span[text() = 'Соусы']"));
    private final SelenideElement bunButton = $(byXpath(".//span[text() = 'Булки']"));
    private final SelenideElement ingredientsButton = $(byXpath(".//span[text() = 'Начинки']"));
    private final SelenideElement activeSection = $(byXpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]"));
    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));
    @Step("нажать на кнопку Булки")
    public MainPage clickBunButton() {
        sauceButton.click();
        bunButton.click();
        return this;
    }
    @Step("нажать на кнопку Соусы")
    public MainPage clickSauceButton() {
        sauceButton.click();
        return this;
    }
    @Step("нажать на кнопку Индигриенты")
    public MainPage clickIngredientsButton() {
        ingredientsButton.click();
        return this;
    }
    @Step("Нажать на кнопку личного кабинет")
    public MainPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }
    @Step("Проверка перехода на страницу входа")
    public MainPage checkLoginPage() {
        Assert.assertThat(enterText.getText(), containsString("Вход"));
        return this;
    }
    @Step("Проверка перехода на нужную вкладку")
    public void checkActiveSection(String section) {
        String actual = activeSection.getText();
        assertEquals(section,actual);
    }
}