package ru.yandex.praktikum.pages_obj;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.Matchers.containsString;

public class MainPage {
    private final SelenideElement personalAccountButton = $(byXpath(".//p[text()='Личный Кабинет']"));
    private final SelenideElement sauceButton = $(byXpath(".//span[text() = 'Соусы']"));
    private final SelenideElement bunButton = $(byXpath(".//span[text() = 'Булки']"));
    private final SelenideElement ingredientsButton = $(byXpath(".//span[text() = 'Начинки']"));
    private final SelenideElement fluorescentBun = $(byXpath(".//p[text() = 'Флюоресцентная булка R2-D3']"));
    private final SelenideElement sauce = $(byXpath(".//p[text() = 'Соус Spicy-X']"));
    private final SelenideElement ingredients = $(byXpath(".//p[text() = 'Мясо бессмертных моллюсков Protostomia']"));

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
    @Step("нажать на кнопку Соусы")
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
    @Step("Проверка перехода на вкладку Булки")
    public MainPage checkingTransitionToBun() {
        Assert.assertThat(fluorescentBun.getText(), containsString("Флюоресцентная булка R2-D3"));
        return this;
    }
    @Step("Проверка перехода на вкладку Булки")
    public MainPage checkingTransitionToSauce() {
        Assert.assertThat(sauce.getText(), containsString("Соус Spicy-X"));
        return this;
    }
    @Step("Проверка перехода на вкладку Булки")
    public MainPage checkingTransitionToIngredients() {
        Assert.assertThat(ingredients.getText(), containsString("Мясо бессмертных моллюсков Protostomia"));
        return this;
    }
}