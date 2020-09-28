package com.habr.account.register;

import com.habr.account.register.elements.SocialButtonEnum;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Feature("Регистрация")
@DisplayName("Проверка регистрации")
public class RegistrationTest extends BeforeAndAfterStep {

    @DisplayName("Проверка окна регистрации")
    @Test
    void startPage(){
        new StartPage(driver)
                .openUrl()
                .testTitle("Регистрация")
                .testFooter()
                .testChangeLanguage()
                .testTitle("Registration")
                .testButtonsAndInputs();
    }
    public static Stream<SocialButtonEnum> stringProvider() {
        return Stream.of(
                SocialButtonEnum.FACEBOOK,
                SocialButtonEnum.VK,
                SocialButtonEnum.TWITTER,
                SocialButtonEnum.LIVE,
                SocialButtonEnum.GIT,
                SocialButtonEnum.GOOGLE
        );
    }
    @DisplayName("Проверка, что кнопки соц сетей работают и содержат верные ссылки")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProvider")
    void testPagesWithPopUp(SocialButtonEnum nameButton){
        new StartPage(driver)
                .openUrl()
                .testClickOnSocialIcon(nameButton);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("testemail@sqvr.ru", "Тестовое Имя","1111","1111"),
                Arguments.of( "test@@fg.ru",  "NNN","11111","1111")
        );
    }
    @DisplayName("Проверка вывода ошибки")
    @ParameterizedTest
    @MethodSource("data")
    void check_pages(String emailText, String nicknameText, String passwordText, String repeatPasswordText) {
        new StartPage(driver)
                .openUrl()
                .testInputWork(emailText, nicknameText, passwordText, repeatPasswordText);
    }
}
