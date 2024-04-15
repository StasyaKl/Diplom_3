package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;
import site.nomoreparties.stellarburgers.pages.RegistrationPage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.*;

public class NegativeRegisterTest extends BaseTest {
    @Test
    @DisplayName("Проверка наудчной регистрации")
    @Description("Метод проверяет возможность регитсрации с паролем, который меньше 6 символов")
    public void checkNegativeRegister() {
        new ConstructorPage(driver)
                .clickEnterToAccount()
                .clickToRegister()
                .fillInputName(userPogo.getName())
                .fillInputEmail(userPogo.getEmail())
                .fillInputPassword(userPogo.setPassword("1234"))
                .clickToRegister();

        assertTrue(new RegistrationPage(driver).isMessageIsDisplayed());
    }
}