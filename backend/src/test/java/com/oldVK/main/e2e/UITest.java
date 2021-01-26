package com.oldVK.main.e2e;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class UITest {
    @BeforeEach
    void init() {
        Configuration.browser = Browsers.CHROME;
    }

    @Test
    void testHomePage() {
        open("http://localhost:8081/");
        $("#home").shouldHave(text("Дуров верни стеночку!"));
    }

    @Test
    void testGoToUsers() {
        open("http://localhost:8081/");
        $(By.linkText("Пользователи")).click();
        $("#users").shouldHave(text("Users"));
    }

    @Test
    void testUserPage() {
        open("http://localhost:8081/user/100500");
        $("#wall").shouldHave(text("Стеночка"));
        $(".post").shouldHave(text("Anya: I don't like frontend T_T"));
        $(By.linkText("Home")).click();
        $("#home").shouldHave(text("Дуров верни стеночку!"));
    }

    @Test
    void testLogin() {
        open("http://localhost:8081/login");
        $("#login").setValue("Anya100500");
        $("#password").setValue("100500");
        $("#login-button").click();
        sleep(2000);
        $(".post").shouldHave(text("Anya: I don't like frontend T_T"));
        $("#exit-button").shouldHave(text("Выход"));
    }
}