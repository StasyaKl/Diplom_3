package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.setup.BasePage;

public class PersonalAccountPage extends BasePage {
    private final By btnEnterToLogout = By.xpath(".//button[text()='Выход']");
    private final By btnProfile = By.xpath(".//a[@aria-current='page' and text()='Профиль']");
    private final By btnConstructor = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private final By btnLogo = By.className("AppHeader_header__logo__2D0X2");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }
    @Step("Нажать на кнопку Выход")
    public LoginPage clickToLogout() {
        waiForDisplay();
        driver.findElement(btnEnterToLogout).click();
        return new LoginPage(driver);
    }
    @Step("Нажать на «Конструктор»")
    public ConstructorPage clickToBtnConstructor() {
        waiForDisplay();
        driver.findElement(btnConstructor).click();
        return new ConstructorPage(driver);
    }
    @Step("Нажать на логотип Stellar Burgers")
    public ConstructorPage clickToLogo() {
        waiForDisplay();
        driver.findElement(btnLogo).click();
        return new ConstructorPage(driver);
    }
    @Step("Убедиться, что открыта страница ЛК")
    public boolean isPersonalAccountWindowDisplayed() {
        return isPageWindowDisplayed(btnProfile);
    }
}
