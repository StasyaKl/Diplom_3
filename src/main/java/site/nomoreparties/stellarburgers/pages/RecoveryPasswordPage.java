package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.setup.BasePage;

public class RecoveryPasswordPage extends BasePage {
    private final By btnToLogin  = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Войти')]");

    public RecoveryPasswordPage(WebDriver driver) {
        super(driver);
    }
    @Step("Нажать на кнопку Войти на форме восстановления пароля")
    public LoginPage clickToLogin() {
        driver.findElement(btnToLogin).click();
        return new LoginPage(driver);
    }
}
