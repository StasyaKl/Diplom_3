package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegistrationPage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsAbilityRegisterParamTest extends BaseTest {
    private final String name;
    private final String email;
    private final String password;
    private final boolean isVisibleMessage;

    public IsAbilityRegisterParamTest(String name, String email, String password, boolean isVisibleMessage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isVisibleMessage = isVisibleMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(6) + "@mail.com", RandomStringUtils.randomAlphabetic(6), false},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(6) + "@mail.com", "12345", true}
        };
    }

    @Test
    @DisplayName("Проверка регистрации")
    @Description("Метод проверяет возможность регитсрации в зависимости от длины пароля")
    public void checkAbilityOrder() {
        new ConstructorPage(driver)
                .clickEnterToAccount()
                .clickToRegister()
                .fillInputName(name)
                .fillInputEmail(email)
                .fillInputPassword(password)
                .clickToRegister();

        boolean isDisplayed;
        if (this.isVisibleMessage) {
            isDisplayed = new RegistrationPage(driver).isMessageIsDisplayed();
        } else {
            isDisplayed = new LoginPage(driver).isLoginWindowDisplayed();
        }
        assertTrue(isDisplayed);
    }
}