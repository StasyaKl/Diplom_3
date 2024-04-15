package site.nomoreparties.stellarburgers.setup;

import site.nomoreparties.stellarburgers.api.UserPogo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static site.nomoreparties.stellarburgers.api.UserAPI.*;
import static site.nomoreparties.stellarburgers.setup.MainPage.URL;

public class BaseTest {
    protected WebDriver driver;
    protected UserPogo userPogo;
    protected String accessToken;

    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        driver.get(URL);

        userPogo = UserPogo.create();
        RestAssured.baseURI = URL;
    }

    public void registerUserWithAPI() {
        postUserCreateRequest(userPogo);
    }

    public void getAccessToken() {
        Response response = postUserLoginRequest(userPogo);
        accessToken = response.path("accessToken").toString().substring(7);
    }

    private WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/geckodriver");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }

    @After
    public void teardown() {
        try {
            getAccessToken();
            deleteUserRequest(accessToken);
        } catch (IllegalArgumentException | NullPointerException exception) {
            System.err.println("An error occurred during teardown: " + exception.getMessage());
        } finally {
            try {
                if (driver != null) {
                    driver.quit();
                }
            } catch (Exception e) {
                System.err.println("An error occurred while quitting the driver: " + e.getMessage());
            }
        }
    }
}