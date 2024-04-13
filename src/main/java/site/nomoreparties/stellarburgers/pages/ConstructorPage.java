package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import site.nomoreparties.stellarburgers.setup.BasePage;

import java.util.List;

public class ConstructorPage extends BasePage {
    private final By btnPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By btnEnterToAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By btnCheckout = By.xpath(".//button[text()='Оформить заказ']");
    private final By sectionCollection = By.xpath(".//*[@class='text text_type_main-default']/parent::div");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку «Личный кабинет» на главной странице. Пользователь не авторизован")
    public LoginPage clickPersonalAccount() {
        driver.findElement(btnPersonalAccount).click();
        return new LoginPage(driver);
    }
    @Step("Нажать на кнопку «Личный кабинет» на главной странице. Пользователь авторизован")
    public PersonalAccountPage clickPersonalAccountAuthUser() {
        driver.findElement(btnPersonalAccount).click();
        return new PersonalAccountPage(driver);
    }
    @Step("Нажать на кнопку «Войти в аккаунт» на главной странице")
    public LoginPage clickEnterToAccount() {
        driver.findElement(btnEnterToAccount).click();
        return new LoginPage(driver);
    }
    @Step("Получить статус раздела")
    public String getSectionClass(int i){
        List<WebElement> elements = driver.findElements(sectionCollection);
        return elements.get(i).getAttribute("class");
    }
    @Step("Нажать на секцию")
    public ConstructorPage clickOnSection(int i){
        List<WebElement> elements = driver.findElements(sectionCollection);
        elements.get(i).click();
        return this;
    }
    @Step("Убедиться, что открыта главная страница и пользователь авторизован")
    public boolean btnIsVisible() {
        waitForDisplay();
        return isPageWindowDisplayed(btnCheckout);
    }
}
