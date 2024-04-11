package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.setup.BasePage;

public class LoginPage extends BasePage {
    private final By inputEmail = By.xpath(".//fieldset[1]//input");
    private final By inputPassword = By.xpath(".//fieldset[2]//input");
    private final By btnToLogin = By.xpath(".//button[text()='Войти']");
    private final By btnToRegister = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Зарегистрироваться')]");
    private final By btnRecoveryPassword = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Восстановить пароль')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Заполнить поле Email")
    public LoginPage fillInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    @Step("Заполнить поле Пароль")
    public LoginPage fillInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }
    @Step("Нажать на кнопку Вход")
    public ConstructorPage clickToLogin() {
        driver.findElement(btnToLogin).click();
        return new ConstructorPage(driver);
    }
    @Step("Нажать на кнопку Зарегистрироваться")
    public RegistrationPage clickToRegister() {
        waiForDisplay();
        driver.findElement(btnToRegister).click();
        return new RegistrationPage(driver);
    }
    @Step("Нажать на кнопку Восстановить пароль")
    public RecoveryPasswordPage clickToRecoveryPassword() {
        driver.findElement(btnRecoveryPassword).click();
        return new RecoveryPasswordPage(driver);
    }
    @Step("Убедиться, что открыта страница логина")
    public boolean isLoginWindowDisplayed() {
        return isPageWindowDisplayed(btnToLogin);
    }
}
