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
import site.nomoreparties.stellarburgers.setup.MainPage;

import static site.nomoreparties.stellarburgers.api.UserAPI.deleteUserRequest;
import static site.nomoreparties.stellarburgers.api.UserAPI.postUserCreateRequest;

public class BaseTest {
    protected WebDriver driver;
    protected UserPogo userPogo;
    protected String accessToken;

    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        driver.get(MainPage.URL);

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";

        userPogo = UserPogo.create();

        Response response = postUserCreateRequest(userPogo);
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
        driver.quit();
        deleteUserRequest(accessToken);
    }
}