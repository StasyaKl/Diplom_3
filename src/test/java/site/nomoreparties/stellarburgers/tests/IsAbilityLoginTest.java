package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class IsAbilityLoginTest extends BaseTest {
    @Before
    public void registerUser() {
        registerUserWithAPI();
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    @Description("Метод проверяет, что после нажатия на «Войти» и заполнения данными, отображается главная страница")
    public void checkLoginEnterToLogin() {
        assertTrue("Пользователь не смог залогиниться",
                new ConstructorPage(driver)
                        .clickEnterToAccount()
                        .fillInputEmail(userPogo.getEmail())
                        .fillInputPassword(userPogo.getPassword())
                        .clickToLogin()
                        .btnIsVisible());
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    @Description("Метод проверяет, что после нажатия на «Личный кабинет» и заполнения данными, отображается главная страница")
    public void checkLoginPersonalAccount() {
        assertTrue("Пользователь не смог залогиниться",
                new ConstructorPage(driver)
                        .clickPersonalAccount()
                        .fillInputEmail(userPogo.getEmail())
                        .fillInputPassword(userPogo.getPassword())
                        .clickToLogin()
                        .btnIsVisible());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    @Description("Метод проверяет, что после нажатия на кнопку в форме регистрации и заполнения данными, отображается главная страница")
    public void checkLoginRegisterForm() {
        assertTrue("Пользователь не смог залогиниться",
                new ConstructorPage(driver)
                        .clickPersonalAccount()
                        .clickToRegister()
                        .clickToLogin()
                        .fillInputEmail(userPogo.getEmail())
                        .fillInputPassword(userPogo.getPassword())
                        .clickToLogin()
                        .btnIsVisible());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Description("Метод проверяет, что после нажатия на кнопку в форме восстановления пароля и заполнения данными, отображается главная страница")
    public void checkLoginRecoveryPasswordForm() {
        assertTrue("Пользователь не смог залогиниться",
                new ConstructorPage(driver)
                        .clickPersonalAccount()
                        .clickToRecoveryPassword()
                        .clickToLogin()
                        .fillInputEmail(userPogo.getEmail())
                        .fillInputPassword(userPogo.getPassword())
                        .clickToLogin()
                        .btnIsVisible());
    }
}