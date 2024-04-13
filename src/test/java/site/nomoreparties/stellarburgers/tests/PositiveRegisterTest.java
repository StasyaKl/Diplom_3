package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.*;

public class PositiveRegisterTest extends BaseTest {
    @Test
    @DisplayName("Проверка успешной регистрации")
    @Description("Метод проверяет возможность регитсрации с корректным паролем")
    public void checkPositiveRegister() {
        new ConstructorPage(driver)
                .clickEnterToAccount()
                .clickToRegister()
                .fillInputName(userPogo.getName())
                .fillInputEmail(userPogo.getEmail())
                .fillInputPassword(userPogo.getPassword())
                .clickToRegister();

        assertTrue(new LoginPage(driver).isLoginWindowDisplayed());
        getAccessToken();
    }
}