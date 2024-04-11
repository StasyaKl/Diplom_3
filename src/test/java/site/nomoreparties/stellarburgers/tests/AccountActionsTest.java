package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.setup.BasePage;
import site.nomoreparties.stellarburgers.setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class AccountActionsTest extends BaseTest {
    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    @Description("Метод проверяет, что после нажатия на кнопку «Выйти» отображается страница логина")
    public void checkLogout() {
        assertTrue("Не удалось найти страницу логина после выхода из ЛК",
                new BasePage(driver)
                        .constructorPageAuthUser(userPogo.getEmail(), userPogo.getPassword())
                        .clickPersonalAccountAuthUser()
                        .clickToLogout()
                        .isLoginWindowDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    @Description("Метод проверяет, что после нажатия на «Личный кабинет» отображается страница ЛК")
    public void checkTransitionByClickingOnPersonalAccount() {
        assertTrue("Не удалось найти страницу ЛК",
                new BasePage(driver)
                        .constructorPageAuthUser(userPogo.getEmail(), userPogo.getPassword())
                        .clickPersonalAccountAuthUser()
                        .isPersonalAccountWindowDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор»")
    @Description("Метод проверяет, что после нажатия на «Конструктор» отображается главная страница")
    public void checkTransitionByClickingOnConstructor() {
        assertTrue("Не удалось найти гланую страницу",
                new BasePage(driver)
                        .constructorPageAuthUser(userPogo.getEmail(), userPogo.getPassword())
                        .clickPersonalAccountAuthUser()
                        .clickToLogo()
                        .btnIsVisible());
    }

    @Test
    @DisplayName("Проверка перехода на логотип Stellar Burgers")
    @Description("Метод проверяет, что после нажатия на логотип отображается главная страница")
    public void checkTransitionByClickingOnLogo() {
        assertTrue("Не удалось найти гланую страницу",
                new BasePage(driver)
                        .constructorPageAuthUser(userPogo.getEmail(), userPogo.getPassword())
                        .clickPersonalAccountAuthUser()
                        .clickToBtnConstructor()
                        .btnIsVisible());
    }
}
