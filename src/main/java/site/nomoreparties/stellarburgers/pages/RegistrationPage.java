package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.setup.BasePage;

public class RegistrationPage extends BasePage {
    private final By inputName = By.xpath(".//fieldset[1]//input");
    private final By inputEmail = By.xpath(".//fieldset[2]//input");
    private final By inputPassword = By.xpath(".//fieldset[3]//input");
    private final By btnToRegister  = By.xpath(".//button[(@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться')]");
    private final By btnToLogin  = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Войти')]");
    private final By errorPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @Step("Заполнить поле Имя")
    public RegistrationPage fillInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        return this;
    }
    @Step("Заполнить поле Email")
    public RegistrationPage fillInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    @Step("Заполнить поле Пароль")
    public RegistrationPage fillInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }
    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickToRegister() {
        driver.findElement(btnToRegister).click();
    }
    @Step("Нажать на кнопку Войти на форме регистрации")
    public LoginPage clickToLogin() {
        driver.findElement(btnToLogin).click();
        return new LoginPage(driver);
    }
    @Step("Проверить, что отображается сообщение при вводе некорректного пароля")
    public boolean isMessageIsDisplayed() {
        return driver.findElement(errorPasswordMessage).isDisplayed();
    }
}
