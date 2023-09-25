package ru.yandex.praktikum.helpers;

import ru.yandex.praktikum.models.User;

public class UserData {
    public static User defaultUserData() {
        return new User("ExampleTestUsr", "ExampleTestUsr@test.ru", "1234Qwer");
    }
    public static User defaultUserLogin() {
        return new User("ExampleTestUsr@test.ru","1234Qwer");
    }
    public static User userDataIncorrectPassword() {
        return new User("ExampleTestUsr", "ExampleTestUsr@test.ru", "123");
    }
}