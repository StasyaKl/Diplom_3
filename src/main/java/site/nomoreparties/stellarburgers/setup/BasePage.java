package site.nomoreparties.stellarburgers.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.pages.ConstructorPage;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean isPageWindowDisplayed(By element) {
        waitForDisplay();
        return driver.findElement(element).isDisplayed();
    }

    public ConstructorPage constructorPageAuthUser(String email, String password) {
        return new ConstructorPage(driver)
                .clickEnterToAccount()
                .fillInputEmail(email)
                .fillInputPassword(password)
                .clickToLogin();
    }

    public void waitForDisplay() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}